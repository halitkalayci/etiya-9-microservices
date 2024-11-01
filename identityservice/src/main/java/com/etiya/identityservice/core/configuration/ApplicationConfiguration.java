package com.etiya.identityservice.core.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class ApplicationConfiguration {
  // 1- Dil çevirileri nereden yüklenecek ? -Dosya,Veritabanı,API
  // 2- Kullanıcıdan dil tercihi nerede alınacak ? - Route google.com/?lng=en, Headers -> Accept-Language ✅✅

  @Bean
  public LocaleResolver localeResolver() {
    AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
    acceptHeaderLocaleResolver.setDefaultLocale(Locale.of("tr"));
    return acceptHeaderLocaleResolver;
  }

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
    resourceBundleMessageSource.setBasename("messages");
    return resourceBundleMessageSource;
  }
}
