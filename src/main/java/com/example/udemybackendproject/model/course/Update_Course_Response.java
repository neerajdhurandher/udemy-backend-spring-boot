package com.example.udemybackendproject.model.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Update_Course_Response {
    private String message;
    private long course_id;
    private String course_name;
    private String domain;
    private long author_id;
    private long duration;
    private int price;
}
