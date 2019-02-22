package com.infoshare.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundMyException extends RuntimeException {


    public ResourceNotFoundMyException(String message) {
        super(message);
    }
}
