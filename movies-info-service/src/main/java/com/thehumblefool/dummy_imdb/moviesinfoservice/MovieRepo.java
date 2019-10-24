package com.thehumblefool.dummy_imdb.moviesinfoservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MovieRepo extends JpaRepository<MovieEntity, Long> {
    Optional<MovieEntity> findByName(String name);

    List<MovieEntity> findByNameLike(String name);

    List<MovieEntity> findByYear(long year);

    List<MovieEntity> findByLang(String lang);
}