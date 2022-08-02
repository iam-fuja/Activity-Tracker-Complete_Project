package com.example.activity_tracker.service.impl;

import com.example.activity_tracker.dto.SigninDto;
import com.example.activity_tracker.dto.SignupDto;
import com.example.activity_tracker.model.User;
import com.example.activity_tracker.repository.UserRepository;
import com.example.activity_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;


    @Override
    public void createUser(SignupDto signupDto) {
        User user1 = User.builder()
                .firstName(signupDto.getFirstName())
                .lastName(signupDto.getLastName())
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .build();

        userRepo.save(user1);
    }

    @Override
    public void loginUser(SigninDto signinDto) throws RuntimeException{
        User user = new User();

        Optional<User> dbuser = Optional.ofNullable(userRepo.findByEmailAndAndPassword(user.getEmail(), user.getPassword()));
        if (dbuser.isPresent()) {


            User user3 = User.builder()
                    .email(signinDto.getEmail())
                    .password(signinDto.getPassword())
                    .build();

            userRepo.save(user3);

  }


    }


}
