package com.cinevibe.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "movie_actor")
    private Set<Movie> movies = new HashSet<>();

    public Actor() {}
    public Actor(String name, Set<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
