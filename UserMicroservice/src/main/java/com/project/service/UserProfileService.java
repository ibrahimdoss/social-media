package com.project.service;

import com.project.document.UserProfile;
import com.project.dto.request.CreateUserRequestDto;
import com.project.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final CacheManager cacheManager;

    public void createUser(CreateUserRequestDto createUserRequestDto) {
        userProfileRepository.save(UserProfile.builder()
                .authId(createUserRequestDto.getAuthId())
                .username(createUserRequestDto.getUsername())
                .email(createUserRequestDto.getEmail())
                .build());

    }

    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    @Cacheable("upperName")
    public String upperName(String name) {
        String result = name.toUpperCase();
        try {
            Thread.sleep(3000L);
        } catch (Exception e) {}
        return result;
    }

    public void clearCache(){
        cacheManager.getCache("upperName").clear();
        //belirli bir keye ait cache silmek için
    }
}
