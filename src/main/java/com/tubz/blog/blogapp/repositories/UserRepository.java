package com.tubz.blog.blogapp.repositories;

import com.tubz.blog.blogapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String userName, String email);
    Optional<User> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
}
