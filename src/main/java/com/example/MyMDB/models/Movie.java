package com.example.MyMDB.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movie",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "release_date" } ))
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long id;
    @NotBlank
    private String title;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie", orphanRemoval = true)
    @Column(name = "cast_and_crew")
    private Set<Credit> credits;
    @Column(name = "plot_synopsis")
    private String plotSynopsis;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    @JsonIgnoreProperties("filmography")
    private Set<GenreTag> genres;
//    @ManyToMany
//    private Set<Language> languages;
//    @Column(name = "country_of_origin")
//    private String countryOfOrigin;
    private Integer runtime;

    public Movie() { }

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

    public Set<Credit> getCredits()
    {
        return credits;
    }

    public void setCredits(Set<Credit> credits)
    {
        this.credits = credits;
    }

    public String getPlotSynopsis()
    {
        return plotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis)
    {
        this.plotSynopsis = plotSynopsis;
    }

    public Set<GenreTag> getGenres()
    {
        return genres;
    }

    public void setGenres(Set<GenreTag> genres)
    {
        this.genres = genres;
    }

    public Integer getRuntime()
    {
        return runtime;
    }

    public void setRuntime(Integer runtime)
    {
        this.runtime = runtime;
    }
}
