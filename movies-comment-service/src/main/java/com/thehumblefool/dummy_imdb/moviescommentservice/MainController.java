package com.thehumblefool.dummy_imdb.moviescommentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    CommentService service;

    @RequestMapping(path = "/user/{userId}")
    public List<CommentDTO> ratingsByUserHandler(@PathVariable(name = "userId") long userId) {      //return all comments by a user
        return service.loadCommentsByUser(userId);
    }

    @RequestMapping(path = "/movie/{movieId}")
    public List<CommentDTO> ratingsByMovieHandler(@PathVariable(name = "movieId") long movieId) {       //return all comments on a movie
        return service.loadCommentsByMovie(movieId);
    }

    @RequestMapping(path = "/count/movie/{movieId}")
    public long ratingCountByMovieHandler(@PathVariable(name = "movieId") long movieId) {       //return comment count of a movie
        return service.loadCommentCountByMovie(movieId);
    }

    @RequestMapping(path = "/comment/user/{userId}/movie/{movideId}")
    public List<CommentDTO> ratingsByUserOfMovieHandler(@PathVariable(name = "userId") long userId,
            @PathVariable(name = "movieId") long movieId) {     //return comment on a movie by a user
        return service.loadCommentByUserOfMovie(userId, movieId);
    }
}
