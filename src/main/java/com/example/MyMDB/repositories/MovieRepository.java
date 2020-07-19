package com.example.MyMDB.repositories;

import com.example.MyMDB.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>
{
}
