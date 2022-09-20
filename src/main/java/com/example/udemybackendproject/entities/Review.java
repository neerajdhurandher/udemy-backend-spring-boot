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
    private long reviewId;
    private long userId;

    private long courseId;
    private String review_description;

    @CreationTimestamp
    private LocalDateTime date_time;


    public Review(long courseId, long userId, String review_description) {
        this.userId = userId;
        this.review_description = review_description;
        this.date_time = LocalDateTime.now();
        this.courseId = courseId;
    }
}
