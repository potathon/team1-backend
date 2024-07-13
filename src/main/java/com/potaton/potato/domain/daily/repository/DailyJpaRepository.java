package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyJpaRepository extends JpaRepository<Daily, Integer> {
}
