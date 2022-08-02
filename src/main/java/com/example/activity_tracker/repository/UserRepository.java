package com.example.activity_tracker.repository;

import com.example.activity_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndAndPassword(String email, String password);
}
