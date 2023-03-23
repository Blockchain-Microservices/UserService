package com.example.userservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private static Long counter = 0L;

    private Long id;

    @Email(regexp="^(.+)@(\\S+)$")
    @NotNull
    private String email;

    @NotEmpty
    private String walletAddress;

    public User(String email, String walletAddress) {
        this.id = counter++;
        this.email = email;
        this.walletAddress = walletAddress;
    }
}
