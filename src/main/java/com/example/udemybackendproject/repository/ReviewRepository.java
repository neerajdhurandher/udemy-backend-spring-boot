package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.entities.Review;
import com.example.udemybackendproject.model.review.Get_Review_Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    @Query("SELECT r FROM Review r where r.courseId = :courseId" )
    List<Review> getReviewList(@Param("courseId") long course_id);
}
