package com.demo.domain;

import lombok.Getter;

@Getter
public class HttpError {
    private String code;
    private String message;

    public HttpError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
