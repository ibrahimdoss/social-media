package com.project.controller;

import com.project.dto.request.LoginRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.entity.AuthEntity;
import com.project.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthEntity> register(@RequestBody RegisterRequestDto requestDto){
        if (!requestDto.getPassword().equals(requestDto.getRePassword())) {
            throw new RuntimeException("Passwords do not match");
        }
        return ResponseEntity.ok(authService.register(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto requestDto){
        return ResponseEntity.ok(authService.login(requestDto));
    }
}
