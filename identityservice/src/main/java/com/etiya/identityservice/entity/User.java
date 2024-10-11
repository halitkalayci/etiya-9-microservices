package com.etiya.identityservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails
{
  @Id
  @GeneratedValue()
  @UuidGenerator()
  private UUID id;
  @Column(name="email")
  private String email;

  @Column(name="password")
  private String password;

  @Column(name="name")
  private String name;

  @Column(name="surname")
  private String surname;

  @Column(name="identityno")
  private String identityNo;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // roller
    return null;
  }

  @Override
  public String getUsername() {
    return email;
  }
}