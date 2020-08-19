package com.example.MyMDB.enums;

import org.junit.Assert;
import org.junit.Test;

public class GenreTypeTest
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
        String actual = GenreType.ROMANCE.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void listEnums()
    {
        String expected = "\nACTION\nCOMEDY\nDRAMA\nFANTASY\nHORROR\nMYSTERY\nROMANCE\nTHRILLER\nWESTERN";
        String actual;
        StringBuilder sb = new StringBuilder();

        for(GenreType el : GenreType.values())
        {
            sb.append(String.format("\n%s", el.toString()));
        }

        actual = sb.toString();
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
