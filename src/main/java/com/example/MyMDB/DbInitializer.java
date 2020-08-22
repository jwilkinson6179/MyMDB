package com.example.MyMDB;

import com.example.MyMDB.enums.GenreType;
import com.example.MyMDB.models.GenreTag;
import com.example.MyMDB.services.GenreTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner
{
    private final GenreTagService genreTagService;

    @Autowired
    public DbInitializer(GenreTagService genreTagService)
    {
        this.genreTagService = genreTagService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        for(GenreType el : GenreType.values())
        {
            if(!genreTagService.findByGenreName(el.toString()).isPresent())
                {GenreTag genre = new GenreTag();
                genre.setGenre(el);
                genre.setMovies(new HashSet<>());
                genreTagService.save(genre);
            }
        }
    }
}
