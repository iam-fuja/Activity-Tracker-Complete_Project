package com.example.activity_tracker.controller;

import com.example.activity_tracker.dto.SigninDto;
import com.example.activity_tracker.dto.SignupDto;
import com.example.activity_tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody SignupDto signupDto) {
        userService.createUser(signupDto);
    }

    @PostMapping("/login-user")
    public ResponseEntity<String> loginUser(@RequestBody SigninDto signinDto) {
        userService.loginUser(signinDto);

        return new ResponseEntity<>("User Login Successful", HttpStatus.ACCEPTED);
        //return "User Login Successful";



    }
}