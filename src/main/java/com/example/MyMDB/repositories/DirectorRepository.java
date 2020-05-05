package com.example.MyMDB.repositories;

import com.example.MyMDB.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long>
{
}
