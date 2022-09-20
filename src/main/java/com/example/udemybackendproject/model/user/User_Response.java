package com.example.udemybackendproject.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User_Response {
    private long userId;
    private String name;
    private String email;
    private int age;
}
