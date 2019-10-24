package com.thehumblefoool.dummy_imdb.moviesratingservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    RatingService service;

    @RequestMapping(path = "/user/{userId}")
    public List<RatingDTO> ratingsByUserHandler(@PathVariable(name = "userId") long userId) { // return all ratings by a
                                                                                              // user
        return service.loadRatingsByUser(userId);
    }

    @RequestMapping(path = "/movie/{movieId}")
    public List<RatingDTO> ratingsByMovieHandler(@PathVariable(name = "movieId") long movieId) { // return all ratings
                                                                                                 // on a movie
        return service.loadRatingsByMovie(movieId);
    }

    @RequestMapping(path = "/count/movie/{movieId}")
    public long ratingCountByMovieHandler(@PathVariable(name = "movieId") long movieId) { // return rating count on a
                                                                                          // movie
        return service.loadRatingCountByMovie(movieId);
    }

    @RequestMapping(path = "/user/{userId}/movie/{movideId}")
    public List<RatingDTO> ratingsByUserOfMovieHandler(@PathVariable(name = "userId") long userId,
            @PathVariable(name = "movieId") long movieId) { // return on a movie by a user
        return service.loadRatingByUserOfMovie(userId, movieId);
    }

    @RequestMapping(path = "/{rating}")
    public List<RatingDTO> greaterRatingsHandler(@PathVariable(name = "rating") double rating) { // return all movies
                                                                                                 // greater with rating
                                                                                                 // greater than given
                                                                                                 // rating
        return service.loadRatingsGreatherThan(rating);
    }
}
