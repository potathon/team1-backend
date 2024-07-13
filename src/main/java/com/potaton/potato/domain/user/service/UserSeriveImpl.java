package com.potaton.potato.domain.user.service;

import com.potaton.potato.domain.user.dto.requestdto.LoginRequestDto;
import com.potaton.potato.domain.user.dto.responsedto.LoginResponseDto;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSeriveImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserSeriveImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        return null;
    }
}
