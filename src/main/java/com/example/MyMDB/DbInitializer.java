package com.example.MyMDB;

import com.example.MyMDB.enums.GenreType;
import com.example.MyMDB.models.GenreTag;
import com.example.MyMDB.models.Language;
import com.example.MyMDB.services.GenreTagService;
import com.example.MyMDB.services.LanguageService;
import com.neovisionaries.i18n.LanguageCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Locale;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner
{
    private final GenreTagService genreTagService;
    private final LanguageService languageService;
    private final Logger log = LoggerFactory.getLogger(DbInitializer.class);

    @Autowired
    public DbInitializer(GenreTagService genreTagService, LanguageService languageService)
    {
        this.genreTagService = genreTagService;
        this.languageService = languageService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        log.info("Generating GenreType Table");
        for(GenreType el : GenreType.values())
        {
            if(!genreTagService.findByGenreName(el.toString()).isPresent())
            {
                GenreTag genre = new GenreTag();
                genre.setGenre(el);
                genre.setMovies(new HashSet<>());
                genreTagService.save(genre);
            }
        }

        log.info("Generating Language table");
        for(LanguageCode el : LanguageCode.values())
        {
            if(!languageService.findByLanguageCode(el.toString())
                    .isPresent())
            {
                Language lang = new Language();
                lang.setLanguage(el);
                lang.setMovies(new HashSet<>());
                languageService.save(lang);
            }
        }
    }
}
