package com.example.MyMDB.models;

import com.example.MyMDB.enums.GenreType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre_tag")
public class GenreTag
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_tag_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private GenreType genre;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "genre_of_movie",
            joinColumns = { @JoinColumn(name = "genre_tag_id")},
            inverseJoinColumns = { @JoinColumn(name = "movie_id")})
    @JsonIgnoreProperties("genres")
    private Set<Movie> movies;

    public GenreTag() { }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public GenreType getGenre()
    {
        return genre;
    }

    public void setGenre(GenreType genre)
    {
        this.genre = genre;
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
