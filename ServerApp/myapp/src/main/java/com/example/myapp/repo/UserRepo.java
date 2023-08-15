package com.example.myapp.repo;

import com.example.myapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findById(Long id);

    List<User> findAll();

    List<User> findAllByOrderByUserIdAsc();
}

