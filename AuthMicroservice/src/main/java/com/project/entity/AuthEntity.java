package com.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "auths")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Boolean isActive;
    private Long createdDate;

}
