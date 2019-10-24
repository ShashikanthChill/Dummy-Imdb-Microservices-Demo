package com.thehumblefool.dummy_imdb.moviesinfoservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidRequestParamException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -1302609429228229032L;

    public InvalidRequestParamException() {
    }

    public InvalidRequestParamException(String string) {
        super(string);
    }

}
