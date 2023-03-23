package com.example.userservice.service.impl;

import com.example.userservice.model.User;
import com.example.userservice.model.UserUpdate;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.example.userservice.util.EmailUtil.validateEmail;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    private final List<User> users = new CopyOnWriteArrayList<>();

    @Override
    public void create(String email, String walletAddress) {
        for (User user: users){
            if(Objects.equals(user.getEmail(),email)){
                throw new IllegalArgumentException("Email already exists");
            }
            if(Objects.equals(user.getWalletAddress(),walletAddress)){
                throw new IllegalArgumentException("Wallet address already exists");
            }
        }
        User newUser = new User(email,walletAddress);
        users.add(newUser);
    }

    @Override
    public void delete(Long id) {
        for(User user: users){
            if (user.getId().equals(id)) {
                users.remove(user);
                return;
            }
        }
        throw new IllegalArgumentException("Cannot find any user with given id");
    }

    @Override
    public void update(UserUpdate user) {
        Long id = user.getId();
        String email = user.getEmail();
        String walletAddress = user.getWalletAddress();
        if (Objects.isNull(email) && Objects.isNull(walletAddress)){
            throw new IllegalArgumentException("You haven't given email or/and wallet address");
        }
        for(User userToUpdate: users){
            if (userToUpdate.getId().equals(id)) {
                if(!Objects.isNull(email)){
                    if(validateEmail(email)){
                        userToUpdate.setEmail(email);
                    }
                    else{
                        throw new IllegalArgumentException("Incorrect format of email address");
                    }
                }
                if(!Objects.isNull(walletAddress)){
                    userToUpdate.setWalletAddress(walletAddress);
                }
                return;
            }
            throw new IllegalArgumentException("Cannot find any user with given id");
        }
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(Long id) {
        for(User user: users){
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Cannot find any user with given id");
    }

    @Override
    public User getByEmail(String email) {
        for(User user: users){
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Cannot find any user with given email");
    }
}
