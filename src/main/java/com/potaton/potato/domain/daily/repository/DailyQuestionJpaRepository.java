package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.DailyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyQuestionJpaRepository extends JpaRepository<DailyQuestion, Long> {
    List<DailyQuestion> findByQuestionId(Long questionId);
}
