package com.thehumblefool.dummy_imdb.moviescommentservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommentNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 5548898826370644401L;

    public CommentNotFoundException() {
    }

    public CommentNotFoundException(String message) {
        super(message);
    }

}
