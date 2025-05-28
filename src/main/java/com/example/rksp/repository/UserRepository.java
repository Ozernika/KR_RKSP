package com.example.rksp.repository;
import com.example.rksp.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);
}
