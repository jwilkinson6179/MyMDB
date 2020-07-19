package com.example.MyMDB.repositories;

import com.example.MyMDB.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long>
{
}
