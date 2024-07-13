package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackJpaRepository  extends JpaRepository<Feedback, Long> {
}
