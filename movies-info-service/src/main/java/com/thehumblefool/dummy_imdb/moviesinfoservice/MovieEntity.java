package com.thehumblefool.dummy_imdb.moviesinfoservice;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies_info")
public class MovieEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String desc;

    @Column(name = "language", nullable = false)
    private String lang;

    @Column(name = "year", nullable = false)
    private long year;

    public MovieEntity() {
    }

    public MovieEntity(long id, String name, String desc, String lang, long year) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.lang = lang;
        this.year = year;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MovieEntity)) {
            return false;
        }
        MovieEntity movieEntity = (MovieEntity) o;
        return id == movieEntity.id && Objects.equals(name, movieEntity.name) && Objects.equals(desc, movieEntity.desc)
                && Objects.equals(lang, movieEntity.lang) && year == movieEntity.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, lang, year);
    }

    @Override
    public String toString() {
        return "Movie: {" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", desc='" + getDesc() + "'" + ", lang='"
                + getLang() + "'" + ", year='" + getYear() + "'" + "}";
    }

}