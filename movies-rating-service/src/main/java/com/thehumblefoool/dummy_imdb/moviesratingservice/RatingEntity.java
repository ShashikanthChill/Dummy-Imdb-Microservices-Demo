package com.thehumblefoool.dummy_imdb.moviesratingservice;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings_info")
public class RatingEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "movie_id", nullable = false)
    private long movieId;

    @Column(name = "rating", nullable = false)
    private double rating;

    public RatingEntity() {
    }

    public RatingEntity(long id, long userId, long movieId, double rating) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RatingEntity)) {
            return false;
        }
        RatingEntity ratingEntity = (RatingEntity) o;
        return id == ratingEntity.id && userId == ratingEntity.userId && movieId == ratingEntity.movieId
                && rating == ratingEntity.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, movieId, rating);
    }

    @Override
    public String toString() {
        return "{" + " id='" + id + "'" + ", userId='" + userId + "'" + ", movieId='" + movieId + "'" + ", rating='"
                + rating + "'" + "}";
    }

}