package com.example.userservice.controller.impl;

import com.example.userservice.controller.UserController;
import com.example.userservice.model.UserCreate;
import com.example.userservice.persistence.entity.User;
import com.example.userservice.model.UserUpdate;
import com.example.userservice.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Controller
public class UserControllerImpl implements UserController {

    private final UserServiceImpl service;

    @Override
    public ResponseEntity<?> create(final UserCreate user) {
        service.create(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> delete(final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> update(final UserUpdate user) {
        service.update(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<User>> getAll() {
        List<User> users = service.getAll();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> getById(final Long id) {
        User user = service.getById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> getByEmail(final String email) {
        User user = service.getByEmail(email);
        return ResponseEntity.ok(user);
    }
}
