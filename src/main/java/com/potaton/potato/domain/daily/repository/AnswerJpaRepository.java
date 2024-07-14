package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByDailyId(Long id);
    List<Answer> findByUserIdAndDailyId(Long userId, Long dailyId);
}
