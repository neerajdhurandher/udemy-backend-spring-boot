package com.example.udemybackendproject.model.general;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class General_Response {
    String status;
    String message;
    LocalDateTime localDateTime;
    String path;
}
