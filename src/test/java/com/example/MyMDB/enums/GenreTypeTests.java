package com.example.MyMDB.enums;

import com.neovisionaries.i18n.CountryCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenreTypeTests
{
    @Test
    public void testOfTest()
    {
        Assert.assertEquals(0, 0);
    }

    @Test
    public void valueOfTest()
    {
        String expected = "HORROR";
        String actual = GenreType.HORROR.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listEnums()
    {
        String expected = "[ACTION,ADVENTURE,ANIMATION,COMEDY,CRIME,DOCUMENTARY,DRAMA,FAMILY,FANTASY,HISTORY,HORROR,MUSICAL,MYSTERY,ROMANCE,SCIFI,THRILLER,WAR,WESTERN]";
        String actual;

        List<GenreType> genreList = Arrays.asList(GenreType.values());
        actual = genreList.stream()
                .map(s -> s.toString())
                .collect(Collectors.joining(",", "[", "]"));

        Assert.assertEquals(expected, actual);
    }
}
