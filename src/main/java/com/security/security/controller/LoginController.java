package com.security.security.controller;

import com.security.security.model.User;
import com.security.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterUser(@RequestBody User user){
        ResponseEntity responseEntity = null;
        try {
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            user.setRole("ROLE_"+ user.getRole());
            User savedUser = userRepo.save(user);
            if (savedUser.getId()>0){
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given User Details are Successfully Registered");
            }


        }catch (Exception ex){
            responseEntity = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("An Exception occured due to " + ex.getMessage());
        }
        return  responseEntity;
    }
}
