package com.etiya.translationservice.repository;

import com.etiya.translationservice.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
