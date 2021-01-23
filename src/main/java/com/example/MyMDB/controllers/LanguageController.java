package com.example.MyMDB.controllers;

import com.example.MyMDB.models.Language;
import com.example.MyMDB.services.LanguageService;
import com.example.MyMDB.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api/language")
public class LanguageController
{
    public final MovieService movieService;
    public final LanguageService languageService;

    @Autowired
    public LanguageController(MovieService movieService, LanguageService languageService)
    {
        this.movieService = movieService;
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Language>> findAll()
    {
        return new ResponseEntity<>(languageService.findAll(), HttpStatus.OK);
    }
}
