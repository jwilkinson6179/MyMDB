package com.example.MyMDB.services;

import com.example.MyMDB.models.Genre;
import com.example.MyMDB.models.Movie;
import com.example.MyMDB.repositories.GenreRepository;
import com.example.MyMDB.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieService
{
    private final MovieRepository movieRepository;
    private final GenreService genreService;

    @Autowired
    public MovieService(MovieRepository movieRepository, GenreService genreService)
    {
        this.movieRepository = movieRepository;
        this.genreService = genreService;
    }

    public Movie save(Movie movie)
    {
        for(Genre el : movie.getGenres())
        {
            Set<Movie> movieSet = el.getMovies();

            if(movieSet == null)
            {
                movieSet = new HashSet<>();
            }
            movieSet.add(movie);
            genreService.save(el);
        }
        return movieRepository.save(movie);
    }

    public Iterable<Movie> findAll()
    {
        return movieRepository.findAll();
    }

    public Optional<Movie> findByid(Long id)
    {
        return movieRepository.findById(id);
    }
}
