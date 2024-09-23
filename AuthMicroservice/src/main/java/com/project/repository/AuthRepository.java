package com.project.repository;

import com.project.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    Boolean existsByUsernameAndPassword(String username, String password);
}
