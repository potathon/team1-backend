package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.dto.responsedto.DailyInfoDto;
import com.potaton.potato.domain.daily.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DailyJpaRepository extends JpaRepository<Daily, Long> {

    @Query("SELECT d FROM Daily d WHERE d.date <= :date")
    List<Daily> findDailiesBeforeOrEqualToDate(@Param("date") LocalDateTime date);

    @Query("SELECT new com.potaton.potato.domain.daily.dto.responsedto.DailyAnswerCountDto(d.id, d.date, COUNT(a.id)) " +
            "CASE WHEN COUNT(a2.id) > 0 THEN TRUE ELSE FALSE END) " +
            "FROM Daily d " +
            "LEFT JOIN Answer a ON d.id = a.daily.id " +
            "LEFT JOIN Answer a2 ON d.id = a2.daily.id AND a2.user.id = :userId " +
            "WHERE d.date <= :today " +
            "GROUP BY d.id, d.date " +
            "ORDER BY d.date DESC")
    List<DailyInfoDto> findDailyWithAnswerCountsAndIsDone(@Param("today") LocalDateTime today, @Param("userId") Long userId);
}
