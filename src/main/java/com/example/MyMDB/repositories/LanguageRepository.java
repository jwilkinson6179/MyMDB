package com.example.MyMDB.repositories;

import com.example.MyMDB.models.Language;
import com.neovisionaries.i18n.LanguageCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>
{
    @Query("SELECT l FROM Language l WHERE l.languageCode = :searchTerm")
    public Optional<Language> findByLanguageCode(@Param("searchTerm") LanguageCode searchTerm);
}
