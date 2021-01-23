package com.example.MyMDB.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neovisionaries.i18n.LanguageCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language
{
    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "language_code", unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageCode languageCode;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "spoken_language",
            joinColumns = { @JoinColumn(name = "language_id") },
            inverseJoinColumns = { @JoinColumn(name = "movie_id")})
    @JsonIgnoreProperties("languages")
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

    public LanguageCode getLanguage()
    {
        return languageCode;
    }

    public void setLanguage(LanguageCode languageCode)
    {
        this.languageCode = languageCode;
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
