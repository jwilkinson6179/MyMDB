package com.example.MyMDB.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    @ManyToMany(mappedBy = "cast")
    Set<Movie> filmography;

    public Actor()
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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Set<Movie> getFilmography()
    {
        return filmography;
    }

    public void setFilmography(Set<Movie> filmography)
    {
        this.filmography = filmography;
    }
}
