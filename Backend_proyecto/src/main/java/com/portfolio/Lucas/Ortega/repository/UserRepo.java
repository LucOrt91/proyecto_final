package com.portfolio.Lucas.Ortega.repository;

import com.portfolio.Lucas.Ortega.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

}
