package com.example.udemybackendproject.model.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Update_Course_Request {

    private long courseId;
    private String courseName;
    private String domain;
    private long duration;
    private int price;
}
