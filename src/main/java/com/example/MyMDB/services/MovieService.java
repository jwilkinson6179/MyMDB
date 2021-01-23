package com.example.MyMDB.services;

import com.example.MyMDB.models.GenreTag;
import com.example.MyMDB.models.Language;
import com.example.MyMDB.models.Movie;
import com.example.MyMDB.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MovieService
{
    private final MovieRepository movieRepository;
    private final GenreTagService genreTagService;
    private final LanguageService languageService;

    @Autowired
    public MovieService(MovieRepository movieRepository, GenreTagService genreTagService, LanguageService languageService)
    {
        this.movieRepository = movieRepository;
        this.genreTagService = genreTagService;
        this.languageService = languageService;
    }

    public Movie save(Movie movie)
    {
        return movieRepository.save(movie);
    }

    public Iterable<Movie> findAll()
    {
        return movieRepository.findAll();
    }

    public Movie findByid(Long id) throws Exception
    {
        return movieRepository.findById(id)
                .orElseThrow(Exception::new);
    }

    public Movie addGenreTag(Long id, String genreName) throws Exception
    {
        GenreTag genre = genreTagService.findByGenreName(genreName)
                .orElseThrow(Exception::new);
        Movie movie = findByid(id);

        Set<Movie> genreMovieSet = genre.getMovies();
        genreMovieSet.add(movie);
        genre.setMovies(genreMovieSet);
        genreTagService.save(genre);

        Set<GenreTag> movieGenreSet = movie.getGenres();
        movieGenreSet.add(genre);
        movie.setGenres(movieGenreSet);

        return movieRepository.save(movie);
    }

    public Movie addLanguage(Long id, String languageCode) throws Exception
    {
        Language lang = languageService.findByLanguageCode(languageCode)
                .orElseThrow(Exception::new);
        Movie movie = findByid(id);

        Set<Movie> moviesOfLanguage = lang.getMovies();
        moviesOfLanguage.add(movie);
        lang.setMovies(moviesOfLanguage);

        Set<Language> languagesOfMovie = movie.getLanguages();
        languagesOfMovie.add(lang);
        movie.setLanguages(languagesOfMovie);

        return movieRepository.save(movie);
    }
}
