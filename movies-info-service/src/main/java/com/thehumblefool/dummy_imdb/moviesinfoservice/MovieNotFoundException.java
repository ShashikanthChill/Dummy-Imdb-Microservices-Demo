package com.thehumblefool.dummy_imdb.moviesinfoservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -1378862864151633691L;

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String string) {
        super(string);
    }
}