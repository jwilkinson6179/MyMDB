package com.example.MyMDB.enums;


import org.junit.Test;
import org.junit.Assert;

public class GenreTagTypeTest
{
    @Test
    public void GenreReturnsName()
    {
        String expected = "Horror";
        String actual = GenreType.HORROR.getGenreName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GenreReturnsNameFalse()
    {
        String expected = "Mystery";
        String actual = GenreType.ACTION.getGenreName();
        Assert.assertNotEquals(expected, actual);
    }
}
