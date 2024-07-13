package com.potaton.potato.global;

import com.potaton.potato.global.Exception.ForbiddenException;
import com.potaton.potato.global.Exception.UnauthorizedException;
import com.potaton.potato.global.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ResponseDto> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        ResponseDto errorResponse = new ResponseDto(401, null);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ResponseDto> handleForbiddenException(ForbiddenException ex, WebRequest request) {
        ResponseDto errorResponse = new ResponseDto(401, null);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
