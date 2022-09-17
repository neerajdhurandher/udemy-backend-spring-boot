package com.example.udemybackendproject.model.review;

import com.example.udemybackendproject.entities.Review;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class Add_Review_Request {
    private long course_id;
    private long user_id;
    private String review_description;

    public Add_Review_Request() {

    }

    public Add_Review_Request(long course_id, long user_id, String review_description) {
        this.course_id = course_id;
        this.user_id = user_id;
        this.review_description = review_description;

    }
}
