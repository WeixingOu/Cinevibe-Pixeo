package com.cinevibe.models;

import com.cinevibe.enums.GENRE;
import javax.persistence.*;

import java.util.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, synopsis, rating;
    private GENRE genre;
    @ManyToMany
    @JoinTable(name = "movie_director")
    private Set<Director> directors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "movie_actor")
    private Set<Actor> actors = new HashSet<>();

    private String coverURL;

    private Movie() {}
    public Movie(String title, String synopsis, String rating, GENRE genre, Set<Director> directors, Set<Actor> actors, String coverURL) {
        this.title = title;
        this.synopsis = synopsis;
        this.rating = rating;
        this.genre = genre;
        this.directors = directors;
        this.actors = actors;
        this.coverURL = coverURL;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public GENRE getGenre() {
        return genre;
    }

    public void setGenre(GENRE genre) {
        this.genre = genre;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }
}
