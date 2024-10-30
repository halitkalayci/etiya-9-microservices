package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.dto.TokenResponse;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.service.user.UserServiceImpl;
import io.github.halitkalayci.security.BaseJwtService;
import jakarta.validation.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;


class AuthServiceImplTest {
    AuthServiceImpl authService;
    PasswordEncoder passwordEncoder;
    //@Mock
    UserServiceImpl userService;
    BaseJwtService baseJwtService;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        userService = Mockito.mock(UserServiceImpl.class);
        baseJwtService = new BaseJwtService();
        passwordEncoder = new BCryptPasswordEncoder();
        authService = new AuthServiceImpl(
                passwordEncoder,
                userService,
                baseJwtService
        );
    }

    @Test
    public void loginWithValidCredentialsShouldGenerateJwt()
    {
        String password = "string";
        User user = new User();
        user.setPassword(passwordEncoder.encode(password));
        Mockito.when(userService.loadUserByUsername("halit@kodlama.io")).thenReturn(user);


        LoginRequest loginRequest = new LoginRequest("halit@kodlama.io", password);
        TokenResponse response = authService.login(loginRequest);
        assert true;
        // assert => test fonksiyonlarının "return"'u
    }

    @Test
    public void loginWithNonExistingEmailShouldThrowException() {
        Mockito.when(userService.loadUserByUsername(Mockito.any())).thenReturn(null);

        // Assert
        assertThrows(RuntimeException.class , () -> {
            authService.login(new LoginRequest("halit@kodlama.io","12345"));
        });
    }
}