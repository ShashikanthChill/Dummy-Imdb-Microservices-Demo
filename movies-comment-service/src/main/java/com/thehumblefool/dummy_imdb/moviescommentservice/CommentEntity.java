package com.thehumblefool.dummy_imdb.moviescommentservice;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comments_info")
public class CommentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "movie_id", nullable = false)
    private long movieId;

    @Column(name = "comment", nullable = false)
    private String comment;

    public CommentEntity() {
    }

    public CommentEntity(long id, long userId, long movieId, String comment) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.comment = comment;
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

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentEntity)) {
            return false;
        }
        CommentEntity commentEntity = (CommentEntity) o;
        return id == commentEntity.id && userId == commentEntity.userId && movieId == commentEntity.movieId
                && comment == commentEntity.comment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, movieId, comment);
    }

    @Override
    public String toString() {
        return "{" + " id='" + id + "'" + ", userId='" + userId + "'" + ", movieId='" + movieId + "'" + ", Comment='"
                + comment + "'" + "}";
    }

}