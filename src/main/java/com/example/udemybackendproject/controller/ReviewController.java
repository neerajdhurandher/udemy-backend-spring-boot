package com.example.udemybackendproject.controller;

import com.example.udemybackendproject.entities.Review;
import com.example.udemybackendproject.model.review.Add_Review_Request;
import com.example.udemybackendproject.model.review.Add_Review_Response;
import com.example.udemybackendproject.services.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;


    @PutMapping("/add-review")
    public ResponseEntity<Add_Review_Response> addReview(@RequestBody Add_Review_Request add_reviewRequest){
        return new ResponseEntity<>(reviewService.addReview(add_reviewRequest), HttpStatus.CREATED);
    }

    @GetMapping("/reviews/{course_id}")
    public ResponseEntity<List<Review>> getReviewList(@PathVariable(value = "course_id") long course_id){
        return new ResponseEntity<>(reviewService.getReviews(course_id), HttpStatus.OK);
    }

}
