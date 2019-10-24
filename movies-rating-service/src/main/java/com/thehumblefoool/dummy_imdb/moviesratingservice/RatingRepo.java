package com.thehumblefoool.dummy_imdb.moviesratingservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RatingRepo extends JpaRepository<RatingEntity, Long> {
    List<RatingEntity> findByUserId(long userId);

    List<RatingEntity> findByMovieId(long movieId);

    long countByMovieId(long movieId);

    Optional<RatingEntity> findByUserIdAndMovieId(long userId, long movieId);

    List<RatingEntity> findByRatingGreaterThan(double rating);
}