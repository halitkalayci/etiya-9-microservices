package com.etiya.identityservice.controller;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.dto.RegisterRequest;
import com.etiya.identityservice.dto.TokenResponse;
import com.etiya.identityservice.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class AuthController {
  private final AuthService authService;

  @PostMapping("login")
  public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest){
    return ResponseEntity.ok(authService.login(loginRequest));
  }


  @PostMapping("register")
  public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest registerRequest){
    return ResponseEntity.ok(authService.register(registerRequest));
  }
}