package com.example.udemybackendproject.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User_Response {
    private long user_id;
    private String name;
    private String email;
    private int age;
}
