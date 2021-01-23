package com.example.MyMDB.controllers;

import com.example.MyMDB.models.Movie;
import com.example.MyMDB.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) throws Exception
    {
        return new ResponseEntity<>(movieService.findByid(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/genre")
    public ResponseEntity<Movie> addGenreTag(@PathVariable Long id, @RequestParam(name = "genre") String genreTag) throws Exception
    {
        return new ResponseEntity<>(movieService.addGenreTag(id, genreTag), HttpStatus.OK);
    }

    @PutMapping("/{id}/language")
    public ResponseEntity<Movie> addLanguage(@PathVariable Long id, @RequestParam(name = "lang") String languageCode) throws Exception
    {
        return new ResponseEntity<>(movieService.addLanguage(id, languageCode), HttpStatus.OK);
    }
}
