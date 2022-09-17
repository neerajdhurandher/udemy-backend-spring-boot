package com.example.udemybackendproject.model.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Course_Response {

    private long course_id;
    private String course_name;
    private String domain;
    private long author_id;
    private long duration;
    private double rating;
    private int price;

}
