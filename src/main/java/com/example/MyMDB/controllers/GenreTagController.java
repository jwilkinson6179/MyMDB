package com.example.MyMDB.controllers;

import com.example.MyMDB.models.GenreTag;
import com.example.MyMDB.services.GenreTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("api/genretag")
public class GenreTagController
{
    private final GenreTagService genreTagService;

    @Autowired
    public GenreTagController(GenreTagService genreTagService)
    {
        this.genreTagService = genreTagService;
    }

    @PostMapping
    public ResponseEntity<GenreTag> save(@Valid @RequestBody GenreTag genreTag)
    {
        return new ResponseEntity<>(genreTagService.save(genreTag), HttpStatus.CREATED);
    }
}
