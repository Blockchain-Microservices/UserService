package com.example.userservice.service.impl;

import com.example.userservice.model.UserCreate;
import com.example.userservice.persistence.entity.User;
import com.example.userservice.model.UserUpdate;
import com.example.userservice.persistence.repository.UserRepository;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(UserCreate user) {
        String userEmail = user.getEmail();
        String userWallet = user.getWalletAddress();
        final Optional<User> optUser = userRepository.findByEmailOrWalletAddress(userEmail, userWallet);
        if (optUser.isPresent()) {
            throw new IllegalArgumentException("Email/Wallet already exists");
        }
        userRepository.save(User.builder()
                .email(userEmail)
                .walletAddress(userWallet)
                .build());
    }

    @Override
    public void delete(Long id) {
        final var optUser = userRepository.findById(id);
        if (optUser.isEmpty()) {
            throw new IllegalStateException("Cannot find user by given id");
        }
        User user = optUser.get();
        userRepository.delete(user);
    }

    @Override
    public void update(UserUpdate user) {
        Long id = user.getId();
        String email = user.getEmail();
        String walletAddress = user.getWalletAddress();
        final var optUser = userRepository.findById(id);
        if (optUser.isEmpty()) {
            throw new IllegalStateException("Cannot find user by given id");
        }
        if (Objects.isNull(email) && Objects.isNull(walletAddress)) {
            throw new IllegalArgumentException("You haven't given email or/and wallet address");
        }
        User userToUpdate = optUser.get();

        if (!Objects.isNull(email)) {
            userToUpdate.setEmail(email);
        }
        if (!Objects.isNull(walletAddress)) {
            userToUpdate.setWalletAddress(walletAddress);
        }
        userRepository.save(userToUpdate);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        final var optUser = userRepository.findById(id);
        if (optUser.isEmpty()) {
            throw new IllegalStateException("Cannot find user by given id");
        }
        return optUser.get();
    }

    @Override
    public User getByEmail(String email) {
        final var optUser = userRepository.findByEmail(email);
        if (optUser.isEmpty()) {
            throw new IllegalStateException("Cannot find any user with given email");
        }
        return optUser.get();
    }
}
