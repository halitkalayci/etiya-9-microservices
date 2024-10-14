package com.etiya.identityservice.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  @NotBlank
  private String email;

  @NotBlank
  //@Pattern(regexp = "")
  private String password;

  @NotBlank
  private String name;
  @NotBlank
  private String surname;

  @NotBlank
  @Size(min = 11, max = 11)
  private String identityNo;
}
