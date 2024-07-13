package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionJpaRepository extends JpaRepository<Question, Integer> {
}
