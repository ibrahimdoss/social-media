package com.project.service;

import com.project.dto.request.CreateUserRequestDto;
import com.project.dto.request.LoginRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.entity.AuthEntity;
import com.project.manager.UserProfileManager;
import com.project.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final UserProfileManager userProfileManager;

    public AuthEntity register(RegisterRequestDto requestDto) {
        AuthEntity auth=  authRepository.save(AuthEntity.builder()
                .username(requestDto.getUsername())
                .password(requestDto.getPassword())
                .email(requestDto.getEmail())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                .authId(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build());
        return auth;
    }

    public Boolean login(LoginRequestDto requestDto) {
        return authRepository.existsByUsernameAndPassword(requestDto.getUsername(), requestDto.getPassword());

    }
}
