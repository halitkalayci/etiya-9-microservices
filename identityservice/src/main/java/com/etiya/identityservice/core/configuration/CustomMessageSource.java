package com.etiya.identityservice.core.configuration;


import jakarta.annotation.PostConstruct;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class CustomMessageSource extends AbstractMessageSource {

  private final RestTemplate restTemplate = new RestTemplate();
  private Map<String, Map<String, String>> messages = new HashMap<>();

  @PostConstruct
  public void loadMessages() {
    System.out.println("******* Getting Translations from service ************");
    String url = "http://localhost:8070/api/v1/translations"; // Dil servisi endpoint’i
    messages = restTemplate.getForObject(url, Map.class);
    System.out.println(messages);
  }

  @Override
  protected MessageFormat resolveCode(String code, Locale locale) {
    System.out.println("Resolving:" + code);
    String lang = locale.getLanguage();
    String message = messages.getOrDefault(lang, new HashMap<>()).get(code);

    if (message == null) {
      // Eğer mesaj bulunamazsa varsayılan olarak İngilizce dilini alır
      message = messages.getOrDefault("en", new HashMap<>()).get(code);
    }

    return new MessageFormat(message != null ? message : "Message not found", locale);
  }
}