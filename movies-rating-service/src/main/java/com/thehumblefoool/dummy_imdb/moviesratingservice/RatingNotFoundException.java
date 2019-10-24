package com.thehumblefoool.dummy_imdb.moviesratingservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RatingNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 5548898826370644401L;

    public RatingNotFoundException() {
    }

    public RatingNotFoundException(String message) {
        super(message);
    }

}
