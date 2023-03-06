package com.rja.projects.mygameslib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GameNotExists extends RuntimeException {
    public GameNotExists(String msg) {
        super(msg);
    }
}
