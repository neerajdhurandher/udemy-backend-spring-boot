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
    private long review_id;
    private String review_description;
    private LocalDateTime date_time;
    private long course_id;
    private String course_name;

    public Add_Review_Response() {
    }

    public Add_Review_Response(String status, long review_id, String review_description, LocalDateTime date_time, long course_id, String course_name) {
        this.status = status;
        this.review_id = review_id;
        this.review_description = review_description;
        this.date_time = date_time;
        this.course_id = course_id;
        this.course_name = course_name;
    }
}
