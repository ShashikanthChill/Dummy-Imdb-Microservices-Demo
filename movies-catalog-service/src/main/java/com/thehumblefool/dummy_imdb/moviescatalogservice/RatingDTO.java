package com.thehumblefool.dummy_imdb.moviescatalogservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "Rating Data")
public class RatingDTO {

    @JsonProperty(value = "User Id")
    private long userId;
    @JsonProperty(value = "Movie Id")
    private long movieId;
    @JsonProperty(value = "Rating")
    private double rating;

    public RatingDTO() {
    }

    public RatingDTO(long userId, long movieId, double rating) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMovieId() {
        return this.movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "{" + " userId='" + userId + "'" + ", movieId='" + movieId + "'" + ", Rating='" + rating + "'" + "}";
    }

}
