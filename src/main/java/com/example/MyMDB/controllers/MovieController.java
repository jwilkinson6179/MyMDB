package com.example.MyMDB.controllers;

import com.example.MyMDB.models.Movie;
import com.example.MyMDB.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/movie")
public class MovieController
{
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie)
    {
        return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> list()
    {
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> addGenreTag(@PathVariable Long id, @RequestParam(name = "genre") String genreTag) throws Exception
    {
        return new ResponseEntity<>(movieService.addGenreTag(id, genreTag), HttpStatus.OK);
    }
}
