package com.example.MyMDB.services;

import com.example.MyMDB.models.Genre;
import com.example.MyMDB.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService
{
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository)
    {
        this.genreRepository = genreRepository;
    }

    public Genre save(Genre genre)
    {
        return genreRepository.save(genre);
    }
}
