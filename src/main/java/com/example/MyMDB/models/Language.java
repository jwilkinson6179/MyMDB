package com.example.MyMDB.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Language
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String language;
    @ManyToMany
    private Set<Movie> movies;

    public Language() { }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public Set<Movie> getMovies()
    {
        return movies;
    }

    public void setMovies(Set<Movie> movies)
    {
        this.movies = movies;
    }
}
