package com.potaton.potato.global.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto<T> {

    private int status;
    private T data;

    @Builder
    public ResponseDto(int httpStatus, T data){
        this.status = httpStatus;
        this.data = data;
    }

}