package com.potaton.potato.domain.user.controller;

import com.potaton.potato.domain.user.dto.requestdto.LoginRequestDto;
import com.potaton.potato.domain.user.dto.responsedto.LoginResponseDto;
import com.potaton.potato.domain.user.repository.UserJpaRepository;
import com.potaton.potato.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = userService.login(loginRequestDto);

        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }
}
