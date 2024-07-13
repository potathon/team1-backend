package com.potaton.potato.domain.user.repository;

import com.potaton.potato.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>{
    Optional<User> findByToken(String token);
}
