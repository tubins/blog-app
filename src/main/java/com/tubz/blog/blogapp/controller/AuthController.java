package com.tubz.blog.blogapp.controller;

import com.tubz.blog.blogapp.dtos.JwtAuthResponse;
import com.tubz.blog.blogapp.dtos.LoginDto;
import com.tubz.blog.blogapp.dtos.SignUpDto;
import com.tubz.blog.blogapp.model.Role;
import com.tubz.blog.blogapp.model.User;
import com.tubz.blog.blogapp.repositories.RoleRepository;
import com.tubz.blog.blogapp.repositories.UserRepository;
import com.tubz.blog.blogapp.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUserNameOrEmail(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String generateToken = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponse(generateToken));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> authenticateUser(@RequestBody SignUpDto signUpDto) {

        Boolean userAlreadyExists = userRepository.existsByUserName(signUpDto.getUserName());
        if (Boolean.TRUE.equals(userAlreadyExists)) {
            return new ResponseEntity<>("User name already exists", HttpStatus.BAD_REQUEST);
        }

        Boolean emailAlreadyExists = userRepository.existsByEmail(signUpDto.getEmail());
        if (Boolean.TRUE.equals(emailAlreadyExists)) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUserName(signUpDto.getUserName());
        user.setEmail(signUpDto.getEmail());
        user.setName(signUpDto.getName());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
