package com.etiya.translationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "language_translations")
public class LanguageTranslation {
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  private String key;

  private String value;

  @ManyToOne
  @JoinColumn(name = "language_id", nullable = false)
  private Language language;
}
