package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.model.UserUpdate;

import java.util.List;

public interface UserService {
    void create(String email, String walletAddress);
    void delete(Long id);
    void update(UserUpdate user);
    List<User> getAll();
    User getById(Long id);
    User getByEmail(String email);
}
