package com.rja.projects.mygameslib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class UserAlreadyHasGame extends RuntimeException {

    public UserAlreadyHasGame(String msg) {
        super(msg);
    }
}
