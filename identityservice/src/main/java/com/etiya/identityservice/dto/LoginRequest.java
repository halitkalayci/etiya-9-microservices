package com.etiya.identityservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest
{
  @NotBlank(message = "{example}")
  @Email(message = "{example}")
  private String email;
  @NotBlank
  private String password;
}