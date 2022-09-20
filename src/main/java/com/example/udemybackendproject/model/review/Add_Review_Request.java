package com.example.udemybackendproject.model.review;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Add_Review_Request {
    private long courseId;
    private long userId;
    private String review_description;

    public Add_Review_Request() {

    }

    public Add_Review_Request(long courseId, long userId, String review_description) {
        this.courseId = courseId;
        this.userId = userId;
        this.review_description = review_description;

    }
}
