package com.thehumblefool.dummy_imdb.moviescatalogservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "movies-info-service")
interface MoviesInfoClient {
    @RequestMapping(path = "/api/movie", method = RequestMethod.GET)
    public List<MovieInfoDTO> getMovieByName(@RequestParam(name = "name") String name);
}