package com.etiya.identityservice.controller;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.dto.RegisterRequest;
import com.etiya.identityservice.dto.TokenResponse;
import com.etiya.identityservice.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.engine.messageinterpolation.DefaultLocaleResolver;
import org.hibernate.validator.internal.engine.messageinterpolation.DefaultLocaleResolverContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class AuthController {
  private final AuthService authService;
  private final MessageSource messageSource;

  @PostMapping("login")
  public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest loginRequest){
    return ResponseEntity.ok(authService.login(loginRequest));
  }


  @PostMapping("register")
  public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest registerRequest){
    return ResponseEntity.ok(authService.register(registerRequest));
  }
  @PostMapping("example")
  public ResponseEntity<String> example() {
    return ResponseEntity.ok(messageSource.getMessage("example",null, LocaleContextHolder.getLocale()));
  }
}