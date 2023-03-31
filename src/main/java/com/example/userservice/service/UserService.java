package com.example.userservice.service;

import com.example.userservice.model.UserCreate;
import com.example.userservice.persistence.entity.User;
import com.example.userservice.model.UserUpdate;

import java.util.List;

public interface UserService {
    void create(UserCreate user);
    void delete(Long id);
    void update(UserUpdate user);
    List<User> getAll();
    User getById(Long id);
    User getByEmail(String email);
}
