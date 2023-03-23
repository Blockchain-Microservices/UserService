package com.example.userservice.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class EmailUtil {
    private final String regexPattern = "^(.+)@(\\S+)$";
    public static Boolean validateEmail(String emailAddress){
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
