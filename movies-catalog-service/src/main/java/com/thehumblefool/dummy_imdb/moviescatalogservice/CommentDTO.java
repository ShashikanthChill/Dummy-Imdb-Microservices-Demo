package com.thehumblefool.dummy_imdb.moviescatalogservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Comment Data")
public class CommentDTO {
    @JsonProperty(value = "User Id")
    private long userId;
    @JsonProperty(value = "Movie Id")
    private long movieId;
    @JsonProperty(value = "Comment")
    private String comment;

    public CommentDTO() {
    }

    public CommentDTO(long userId, long movieId, String comment) {
        this.userId = userId;
        this.movieId = movieId;
        this.comment = comment;
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

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "{" + " userId='" + userId + "'" + ", movieId='" + movieId + "'" + ", comment='" + comment + "'" + "}";
    }

}