package com.example.MyMDB.repositories;

import com.example.MyMDB.enums.GenreType;
import com.example.MyMDB.models.GenreTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreTagRepository extends JpaRepository<GenreTag, Long>
{
    @Query("SELECT gt FROM GenreTag gt WHERE gt.genre = :searchTerm")
    public Optional<GenreTag> findByGenreName(@Param("searchTerm") GenreType searchTerm);
}
