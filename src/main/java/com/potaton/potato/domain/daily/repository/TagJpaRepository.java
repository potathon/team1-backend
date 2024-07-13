package com.potaton.potato.domain.daily.repository;

import com.potaton.potato.domain.daily.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagJpaRepository extends JpaRepository<Tag, Long> {
}
