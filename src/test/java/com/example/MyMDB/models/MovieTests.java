package com.example.MyMDB.models;

import com.example.MyMDB.enums.GenreType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MovieTests
{
    @Test
    public void gettersAndSettersTest()
    {
        Movie testMovie = new Movie();
        GenreTag gTag = new GenreTag();
        gTag.setId(500L);
        gTag.setMovies(new HashSet<>(Arrays.asList(testMovie)));
        gTag.setGenre(GenreType.ACTION);

        Long expectedId = 50L;
        String expectedTitle = "Test Movie";
        LocalDate expectedReleaseDate = LocalDate.of(2020, 8, 22);
        String expectedPlot = "Test plot";
        Set<GenreTag> expectedGenres = new HashSet<>(Arrays.asList(gTag));
        Integer expectedRuntime = 75;

        testMovie.setId(50L);
        testMovie.setTitle("Test Movie");
        testMovie.setReleaseDate(LocalDate.of(2020, 8, 22));
        testMovie.setPlotSynopsis("Test plot");
        testMovie.setGenres(new HashSet<>(Arrays.asList(gTag)));
        testMovie.setRuntime(75);

        Assertions.assertEquals(expectedId, testMovie.getId());
        Assertions.assertEquals(expectedTitle, testMovie.getTitle());
        Assertions.assertEquals(expectedReleaseDate, testMovie.getReleaseDate());
        Assertions.assertEquals(expectedPlot, testMovie.getPlotSynopsis());
        Assertions.assertEquals(expectedGenres, testMovie.getGenres());
        Assertions.assertEquals(expectedRuntime, testMovie.getRuntime());
    }
}
