package com.example.udemybackendproject.Interface;

import com.example.udemybackendproject.entities.Review;
import com.example.udemybackendproject.model.review.Add_Review_Response;
import com.example.udemybackendproject.model.review.Add_Review_Request;
import com.example.udemybackendproject.model.review.Get_Review_Response;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewServiceInterface {
    Add_Review_Response addReview(Add_Review_Request add_reviewRequest);
    Review getReviewById(long review_id);
    List<Review> getReviewsByCourseId(long course_id);
    Review updateReview(Review review, long review_id);
    void deleteReview(long review_id);
    List<Review> getReviews(long course_id);
}
