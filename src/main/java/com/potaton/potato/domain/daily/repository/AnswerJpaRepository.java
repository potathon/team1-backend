package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerJpaRepository extends JpaRepository<Answer, Integer> {

}
