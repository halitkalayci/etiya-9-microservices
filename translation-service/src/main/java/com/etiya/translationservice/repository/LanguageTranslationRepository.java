package com.etiya.translationservice.repository;

import com.etiya.translationservice.entity.LanguageTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LanguageTranslationRepository extends JpaRepository<LanguageTranslation, UUID> {
}
