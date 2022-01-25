package com.example.cargoClientApi.service;

import com.example.cargoClientApi.pojo.LoginRequest;
import com.example.cargoClientApi.pojo.SignupRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authUser(LoginRequest loginRequest);

    ResponseEntity<?> registerUser(SignupRequest signupRequest);
}
