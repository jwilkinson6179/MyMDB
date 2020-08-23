package com.example.MyMDB.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "person",
        uniqueConstraints =
        @UniqueConstraint(columnNames = { "first_name", "last_name", "birthdate" }))
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;
    @NotBlank
    @Size(min = 2, max = 32, message = "Valid names must be between 3 and 64 characters in length")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 32, message = "Valid names must be between 3 and 64 characters in length")
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    private LocalDate birthdate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person", orphanRemoval = true)
    @JsonIgnoreProperties("credits")
    private Set<Credit> filmography;
    private String nationality;

    public Person() { }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate)
    {
        this.birthdate = birthdate;
    }

    public Set<Credit> getFilmography()
    {
        return filmography;
    }

    public void setFilmography(Set<Credit> filmography)
    {
        this.filmography = filmography;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }
}
