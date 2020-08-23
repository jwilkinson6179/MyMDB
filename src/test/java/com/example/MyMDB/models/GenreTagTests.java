package com.example.MyMDB.models;

import com.example.MyMDB.enums.GenreType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GenreTagTests
{
    @Test
    public void gettersAndSetters()
    {
        Long expectedId = 25L;
        GenreType expectedGenre = GenreType.DOCUMENTARY;
        Movie testMovie = new Movie();
        Set<Movie> expectedMovies = new HashSet<>(Arrays.asList(testMovie));
        GenreTag testTag = new GenreTag();
        testTag.setId(25L);
        testTag.setGenre(GenreType.DOCUMENTARY);
        testTag.setMovies(new HashSet<>(Arrays.asList(testMovie)));

        Assertions.assertEquals(expectedId, testTag.getId());
        Assertions.assertEquals(expectedGenre, testTag.getGenre());
        Assertions.assertEquals(expectedMovies, testTag.getMovies());
    }
}
