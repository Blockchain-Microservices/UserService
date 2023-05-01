package com.example.userservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserCreate{
    @Email(regexp="^(.+)@(\\S+)$")
    @NotNull
    private String email;

    @NotEmpty
    private String walletAddress;
}
