package com.example.userservice.controller;

import com.example.userservice.model.User;
import com.example.userservice.model.UserUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("user")
public interface UserController {
    @PostMapping("create")
    ResponseEntity<?> create(
            @RequestBody @Valid @NotNull User user
    );

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> delete(
            @PathVariable Long id
    );

    @PutMapping("update")
    ResponseEntity<?> update(
            @RequestBody @Valid @NotNull UserUpdate user
    );

    @GetMapping("getAll")
    ResponseEntity<List<User>> getAll(
    );

    @GetMapping("getById/{id}")
    ResponseEntity<User> getById(
            @PathVariable Long id
    );

    @GetMapping("getByEmail/{email}")
    ResponseEntity<User> getByEmail(
            @PathVariable String email
    );





}
