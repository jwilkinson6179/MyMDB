package com.example.MyMDB.services;

import com.example.MyMDB.models.Language;
import com.example.MyMDB.repositories.LanguageRepository;
import com.neovisionaries.i18n.LanguageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class LanguageService
{
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository)
    {
        this.languageRepository = languageRepository;
    }

    public Language save(Language language)
    {
        return languageRepository.save(language);
    }

    public Optional<Language> findByLanguageCode(String code)
    {
        return languageRepository.findByLanguageCode(LanguageCode.valueOf(code.toLowerCase(Locale.ENGLISH)));
    }

    public Iterable<Language> findAll()
    {
        return languageRepository.findAll();
    }
}
