package com.example.MyMDB.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private LocalDate releaseDate;
    @ManyToMany
    Set<Actor> cast;

    public Movie()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDate getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public Set<Actor> getCast()
    {
        return cast;
    }

    public void setCast(Set<Actor> cast)
    {
        this.cast = cast;
    }
}
