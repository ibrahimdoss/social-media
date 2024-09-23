package com.project.manager;

import com.project.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://service-loadbalancer-user:9091/user-profile", name="userProfileManager")
//yukarıda localhostu sildim ve service-loadbalancer-user:9091/user-profile ekledim çünkü
//bu servisler arası iletişimde kullanılan bir yapıdır ve localhost kullanılmaz
// kubernetes cluster de localhost kullanılmaz ve
//service-loadbalancer-user:9091/user-profile şeklinde kullanılır
public interface UserProfileManager {

    @PostMapping("/create")
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto createUserRequestDto);
}
