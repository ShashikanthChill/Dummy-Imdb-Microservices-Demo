package com.thehumblefool.dummy_imdb.moviesinfoservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestParamFormatException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -8988024108836323590L;

    public RequestParamFormatException() {
    }

    public RequestParamFormatException(String string) {
        super(string);
    }

}