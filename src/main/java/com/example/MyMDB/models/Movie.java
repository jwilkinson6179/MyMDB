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
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie", orphanRemoval = true)
//    @Column(name = "cast_and_crew")
//    private Set<Credit> castAndCrew;
//    @Column(name = "plot_synopsis")
//    private String plotSynopsis;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private Set<GenreTag> genreTags;
//    @ManyToMany
//    private Set<Language> languages;
//    @Column(name = "country_of_origin")
//    private String countryOfOrigin;
//    private Integer runtime;

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

    public Set<GenreTag> getGenres()
    {
        return genreTags;
    }

    public void setGenres(Set<GenreTag> genreTags)
    {
        this.genreTags = genreTags;
    }

    //    public String getPlotSynopsis()
//    {
//        return plotSynopsis;
//    }
//
//    public void setPlotSynopsis(String plotSynopsis)
//    {
//        this.plotSynopsis = plotSynopsis;
//    }
//
//    public Integer getRuntime()
//    {
//        return runtime;
//    }
//
//    public void setRuntime(Integer runtime)
//    {
//        this.runtime = runtime;
//    }
}
