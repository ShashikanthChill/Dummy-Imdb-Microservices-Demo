package com.thehumblefool.dummy_imdb.moviesinfoservice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepo repo;

    public List<MovieDTO> loadMovieByName(String name) {
        Optional<MovieEntity> movie = repo.findByName(name);
        if (movie.isPresent())
            return mapMovieEntityToDTO(Arrays.asList(new MovieEntity[] { movie.get() }));
        return loadMoviesByNameLike(name);
    }

    public List<MovieDTO> loadMoviesByNameLike(String name) {
        List<MovieEntity> moviesByNameLike = repo.findByNameLike(name);
        if (moviesByNameLike.isEmpty())
            throw new MovieNotFoundException("No movie found with name like: " + name);
        return mapMovieEntityToDTO(moviesByNameLike);
    }

    public List<MovieDTO> loadMoviesByLanguage(String lang) {
        List<MovieEntity> moviesByLang = repo.findByLang(lang);
        if (moviesByLang.isEmpty())
            throw new MovieNotFoundException("No movie found for lang: " + lang);
        return mapMovieEntityToDTO(moviesByLang);
    }

    public List<MovieDTO> loadMoviesByYear(long year) {
        List<MovieEntity> moviesByYear = repo.findByYear(year);
        if (moviesByYear.isEmpty())
            throw new MovieNotFoundException("No movie found for release year: " + year);
        return mapMovieEntityToDTO(moviesByYear);
    }

    public List<MovieDTO> mapMovieEntityToDTO(List<MovieEntity> movieEntities) {
        return movieEntities.stream()
                .map(e -> new MovieDTO(e.getId(), e.getName(), e.getDesc(), e.getLang(), e.getYear()))
                .collect(Collectors.toList());
    }
}