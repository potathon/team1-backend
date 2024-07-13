package com.potaton.potato.domain.user.service;

import com.potaton.potato.domain.user.dto.requestdto.LoginRequestDto;
import com.potaton.potato.domain.user.dto.responsedto.LoginResponseDto;
import com.potaton.potato.domain.user.entity.User;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import com.potaton.potato.global.Exception.ForbiddenException;
import com.potaton.potato.global.Exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSeriveImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserSeriveImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user;
        user = userJpaRepository.findByToken(loginRequestDto.getToken())
                 .orElseThrow(UnauthorizedException::new);
        return new LoginResponseDto(user.getId(), user.getName());
    }1
}
