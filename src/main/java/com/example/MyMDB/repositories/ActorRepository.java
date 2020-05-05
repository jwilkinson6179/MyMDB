package com.example.MyMDB.repositories;

import com.example.MyMDB.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long>
{
}
