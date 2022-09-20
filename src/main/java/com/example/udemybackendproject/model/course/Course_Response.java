package com.example.udemybackendproject.model.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Course_Response {

    private long courseId;
    private String course_name;
    private String domain;
    private long authorId;
    private long duration;
    private double rating;
    private int price;

}
