package com.example.MyMDB.services;

import com.example.MyMDB.enums.GenreType;
import com.example.MyMDB.models.GenreTag;
import com.example.MyMDB.repositories.GenreTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreTagService
{
    private final GenreTagRepository genreTagRepository;

    @Autowired
    public GenreTagService(GenreTagRepository genreTagRepository)
    {
        this.genreTagRepository = genreTagRepository;
    }

    public GenreTag save(GenreTag genreTag)
    {
        return genreTagRepository.save(genreTag);
    }

    public Optional<GenreTag> findByGenreName(String name)
    {
        return genreTagRepository.findByGenreName(GenreType.valueOf(name.toUpperCase()));
    }
}
