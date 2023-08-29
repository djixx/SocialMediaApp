package com.example.myapp.repo;

import com.example.myapp.enumeration.Role;
import com.example.myapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    int countByUsername(String username);

    Optional<User>findByUsername(String username);

    Optional<User> findById(Long id);

    List<User> findAll();

    List<User> findAllByOrderByUserIdAsc();

    @Query("select u from User u where u.role != :adminRole " +
            "order by u.userId asc ")
    List<User> findAllNonAdmin(Role adminRole);


}

