package com.demo.domain;

import lombok.Getter;

@Getter
public class HttpError {
    private int code;
    private String message;

    public HttpError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
