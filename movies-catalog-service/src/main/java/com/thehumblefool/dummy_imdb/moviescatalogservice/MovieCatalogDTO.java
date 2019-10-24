package com.thehumblefool.dummy_imdb.moviescatalogservice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Movie Catalog Data")
public class MovieCatalogDTO {
    @JsonProperty(value = "Movie Id")
    private long movieId;
    @JsonProperty(value = "Movie Name")
    private String moviename;
    @JsonProperty(value = "Description")
    private String desc;
    @JsonProperty(value = "Language")
    private String lang;
    @JsonProperty(value = "Year")
    private long year;
    @JsonProperty(value = "Rating & Comments")
    private List<RatingAndCommentDTO> ratingAndComments;

    public MovieCatalogDTO() {
    }

    public MovieCatalogDTO(long movieId, String moviename, String desc, String lang, long year,
            List<RatingAndCommentDTO> ratingAndComments) {
        this.movieId = movieId;
        this.moviename = moviename;
        this.desc = desc;
        this.lang = lang;
        this.year = year;
        this.ratingAndComments = ratingAndComments;
    }

    public long getMovieId() {
        return this.movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMoviename() {
        return this.moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getYear() {
        return this.year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public List<RatingAndCommentDTO> getRatingAndComments() {
        return this.ratingAndComments;
    }

    public void setRatingAndComments(List<RatingAndCommentDTO> ratingAndComments) {
        this.ratingAndComments = ratingAndComments;
    }

    @Override
    public String toString() {
        return "{" + " movieId='" + movieId + "'" + ", moviename='" + moviename + "'" + ", desc='" + desc + "'"
                + ", lang='" + lang + "'" + ", year='" + year + "'" + ", ratingAndComments='" + ratingAndComments + "'"
                + "}";
    }

}
