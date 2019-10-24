package com.thehumblefool.dummy_imdb.moviescatalogservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "Movie Data")
public class MovieInfoDTO {
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

    public MovieInfoDTO() {
    }

    public MovieInfoDTO(long movieId, String moviename, String desc, String lang, long year) {
        this.movieId = movieId;
        this.moviename = moviename;
        this.desc = desc;
        this.lang = lang;
        this.year = year;
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

    @Override
    public String toString() {
        return "{" + " movieId='" + movieId + "'" + ", moviename='" + moviename + "'" + ", desc='" + desc + "'"
                + ", lang='" + lang + "'" + ", year='" + year + "'" + "}";
    }
}