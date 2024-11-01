package com.etiya.translationservice.controller;

import com.etiya.translationservice.entity.Language;
import com.etiya.translationservice.entity.LanguageTranslation;
import com.etiya.translationservice.repository.LanguageRepository;
import com.etiya.translationservice.repository.LanguageTranslationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/translations")
@RequiredArgsConstructor
public class TranslationController {
  private final LanguageRepository languageRepository;

  private final LanguageTranslationRepository translationRepository;

  @GetMapping("")
  public Map<String, Map<String, String>> getTranslations() {
    // Tüm dillerin ve çevirilerin listelerini al
    List<Language> languages = languageRepository.findAll();
    List<LanguageTranslation> translations = translationRepository.findAll();

    // Dilleri JSON formatında dönecek şekilde düzenle
    return languages.stream()
            .collect(Collectors.toMap(
                    Language::getName,
                    language -> translations.stream()
                            .filter(t -> t.getLanguage().equals(language))
                            .collect(Collectors.toMap(
                                    LanguageTranslation::getKey,
                                    LanguageTranslation::getValue
                            ))
            ));
  }

  @PostMapping
  public void post(@RequestBody Language language){
    languageRepository.save(language);
  }
}
