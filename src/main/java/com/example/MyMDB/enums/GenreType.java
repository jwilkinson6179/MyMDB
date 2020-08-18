package com.example.MyMDB.enums;

public enum GenreType
{

    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    FANTASY("Fantasy"),
    HORROR("Horror"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    THRILLER("Thriller"),
    WESTERN("Western");

    private final String genreName;

    private GenreType(String genreName)
    {
        this.genreName = genreName;
    }

    public String getGenreName()
    {
        return this.genreName;
    }
}
