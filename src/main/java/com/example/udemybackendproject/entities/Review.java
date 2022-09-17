package com.example.udemybackendproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long review_id;
    private long user_id;

    private long course_id;
    private String review_description;

    @CreationTimestamp
    private LocalDateTime date_time;


    public Review(long course_id, long user_id, String review_description) {
        this.user_id = user_id;
        this.review_description = review_description;
        this.date_time = LocalDateTime.now();
        this.course_id = course_id;
    }
}
