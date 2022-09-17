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

    private long review_id;
    private long course_id;
    private long user_id;
    private String review_description;
    private LocalDateTime date_time;


    public Get_Review_Response(long review_id, long user_id, String review_description, LocalDateTime date_time, long course_id) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.review_description = review_description;
        this.date_time = date_time;
        this.course_id = course_id;
    }
}
