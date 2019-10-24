package com.thehumblefoool.dummy_imdb.moviesratingservice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    RatingRepo repo;

    public List<RatingDTO> loadRatingsByUser(long userId) {
        List<RatingEntity> ratingsByUserId = repo.findByUserId(userId);
        if (ratingsByUserId.isEmpty())
            throw new RatingNotFoundException("No ratings found by userId: " + userId);
        return mapRatingEntityToDTO(ratingsByUserId);
    }

    public List<RatingDTO> loadRatingsByMovie(long movieId) {
        List<RatingEntity> ratingsByMovie = repo.findByMovieId(movieId);
        if (ratingsByMovie.isEmpty())
            throw new RatingNotFoundException("No ratings found for movieId: " + movieId);
        return mapRatingEntityToDTO(ratingsByMovie);
    }

    public long loadRatingCountByMovie(long movieId) {
        return repo.countByMovieId(movieId);
    }

    public List<RatingDTO> loadRatingByUserOfMovie(long userId, long movieId) {
        Optional<RatingEntity> ratingByUserIdOfMovieId = repo.findByUserIdAndMovieId(userId, movieId);
        return mapRatingEntityToDTO(Arrays
                .asList(new RatingEntity[] { ratingByUserIdOfMovieId.orElseThrow(() -> new RatingNotFoundException(
                        "No rating found by userId: " + userId + " for movieId: " + movieId)) }));
    }

    public List<RatingDTO> loadRatingsGreatherThan(double rating) {
        List<RatingEntity> greaterRatings = repo.findByRatingGreaterThan(rating);
        if (greaterRatings.isEmpty())
            throw new RatingNotFoundException("No rating greater than: " + rating + " found");
        return mapRatingEntityToDTO(greaterRatings);
    }

    private List<RatingDTO> mapRatingEntityToDTO(List<RatingEntity> ratingEntities) {
        return null;
    }
}