package com.example.MyMDB.models;

import com.example.MyMDB.enums.GenreType;
import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals(expectedId, testMovie.getId());
        Assert.assertEquals(expectedTitle, testMovie.getTitle());
        Assert.assertEquals(expectedReleaseDate, testMovie.getReleaseDate());
        Assert.assertEquals(expectedPlot, testMovie.getPlotSynopsis());
        Assert.assertEquals(expectedGenres, testMovie.getGenres());
        Assert.assertEquals(expectedRuntime, testMovie.getRuntime());
    }
}
