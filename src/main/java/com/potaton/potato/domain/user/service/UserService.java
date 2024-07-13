package com.potaton.potato.domain.user.service;

import com.potaton.potato.domain.user.dto.requestdto.LoginRequestDto;
import com.potaton.potato.domain.user.dto.requestdto.responsedto.LoginResponseDto;

public interface UserService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
