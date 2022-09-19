package com.example.udemybackendproject.model.review;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Component
@Data
public class Add_Review_Response {


    private String status;
    private long reviewId;
    private String reviewDescription;
    private LocalDateTime dateTime;
    private long courseId;
    private String courseName;

    public Add_Review_Response() {
    }

    public Add_Review_Response(String status, long reviewId, String reviewDescription, LocalDateTime dateTime, long courseId, String courseName) {
        this.status = status;
        this.reviewId = reviewId;
        this.reviewDescription = reviewDescription;
        this.dateTime = dateTime;
        this.courseId = courseId;
        this.courseName = courseName;
    }
}
