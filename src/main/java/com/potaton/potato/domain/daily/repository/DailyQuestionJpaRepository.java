package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.DailyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyQuestionJpaRepository extends JpaRepository<DailyQuestion, Long> {
}
