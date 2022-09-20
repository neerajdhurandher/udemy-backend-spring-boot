package com.example.udemybackendproject.model.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Get_Review_Response {

    private long reviewId;
    private long courseId;
    private long userId;
    private String reviewDescription;
    private LocalDateTime dateTime;


    public Get_Review_Response(long reviewId, long userId, String reviewDescription, LocalDateTime dateTime, long courseId) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.reviewDescription = reviewDescription;
        this.dateTime = dateTime;
        this.courseId = courseId;
    }
}
