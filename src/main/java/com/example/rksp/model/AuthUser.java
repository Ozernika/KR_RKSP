package com.example.rksp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import lombok.*;
import jakarta.persistence.Id;

@Data
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean active = false;
}