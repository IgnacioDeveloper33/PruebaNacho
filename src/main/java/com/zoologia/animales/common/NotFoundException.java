package com.zoologia.animales.common;

import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends RuntimeException{
    private final String code;

    public NotFoundException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    @Generated
    public String getCode(){return this.code;}
}
