package com.etiya.identityservice.controller;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.dto.RegisterRequest;
import com.etiya.identityservice.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("login")
  public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
    return ResponseEntity.ok(authService.login(loginRequest));
  }


  @PostMapping("register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
    return ResponseEntity.ok(authService.register(registerRequest));
  }
}