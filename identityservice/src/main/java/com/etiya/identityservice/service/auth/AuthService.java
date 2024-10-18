package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.dto.RegisterRequest;
import com.etiya.identityservice.dto.TokenResponse;

public interface AuthService {
  TokenResponse login(LoginRequest loginRequest);
  TokenResponse register(RegisterRequest registerRequest);
}
