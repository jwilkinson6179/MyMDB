package com.example.MyMDB.repositories;

import com.example.MyMDB.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long>
{
}
