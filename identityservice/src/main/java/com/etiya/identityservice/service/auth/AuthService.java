package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.LoginRequest;

public interface AuthService {
  String login(LoginRequest loginRequest);
}
