package com.thehumblefool.dummy_imdb.moviescatalogservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "movies-comment-service")
interface MoviesCommentClient {
    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public List<CommentDTO> getCommentsByUser(@PathVariable(name = "userId") long userId);

    @RequestMapping(path = "/movie/{movieId}", method = RequestMethod.GET)
    public List<CommentDTO> getCommentsByMovie(@PathVariable(name = "movieId") long movieId);

    @RequestMapping(path = "/count/movie/{movieId}", method = RequestMethod.GET)
    public long getCommentCountByMovie(@PathVariable(name = "movieId") long movieId);

    @RequestMapping(path = "/user/{userId}/movie/{movideId}", method = RequestMethod.GET)
    public List<CommentDTO> getCommentByUserOfMovie(@PathVariable(name = "userId") long userId,
            @PathVariable(name = "movieId") long movieId);
}