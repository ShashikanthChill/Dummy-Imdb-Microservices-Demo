package com.thehumblefool.dummy_imdb.moviescatalogservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Rating & Comment Data")
public class RatingAndCommentDTO {

    @JsonProperty(value = "User Id")
    private long userId;
    @JsonProperty(value = "Rating")
    private double rating;
    @JsonProperty(value = "Comment")
    private String comment;

    public RatingAndCommentDTO() {
    }

    public RatingAndCommentDTO(long userId, double rating, String comment) {
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "{" + " userId='" + userId + "'" + ", rating='" + rating + "'" + ", comment='" + comment + "'" + "}";
    }

}
