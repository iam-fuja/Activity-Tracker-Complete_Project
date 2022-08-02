package com.example.activity_tracker.service;

import com.example.activity_tracker.dto.SigninDto;
import com.example.activity_tracker.dto.SignupDto;

public interface UserService {
        void createUser(SignupDto signupDto);

        void loginUser(SigninDto signinDto);
}


