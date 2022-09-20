package com.example.udemybackendproject.services;

import com.example.udemybackendproject.Interface.ReviewServiceInterface;
import com.example.udemybackendproject.entities.Course;
import com.example.udemybackendproject.entities.Review;
import com.example.udemybackendproject.entities.User;
import com.example.udemybackendproject.exceptions.ResourceNotFoundException;
import com.example.udemybackendproject.model.review.Add_Review_Response;
import com.example.udemybackendproject.model.review.Add_Review_Request;
import com.example.udemybackendproject.repository.CourseRepository;
import com.example.udemybackendproject.repository.ReviewRepository;
import com.example.udemybackendproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewServiceInterface {

    private final ReviewRepository reviewRepository;
    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CourseRepository courseRepository, UserRepository userRepository){
        super();
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Add_Review_Response addReview(Add_Review_Request add_reviewRequest) {

        Optional<Course> Ocourse = courseRepository.findById(add_reviewRequest.getCourseId());

        if(!Ocourse.isPresent())
            throw  new ResourceNotFoundException("UnSuccess! Course not found with course id "+ add_reviewRequest.getCourseId());

        Optional<User> user = userRepository.findById(add_reviewRequest.getUserId());

        if(!user.isPresent())
            throw  new ResourceNotFoundException("UnSuccess! User not found with user id "+ add_reviewRequest.getUserId());

        Course course = Ocourse.get();

        Review review = new Review(add_reviewRequest.getCourseId(), add_reviewRequest.getUserId(), add_reviewRequest.getReview_description());

        course.getReviewList().add(review);

        this.reviewRepository.save(review);
        this.courseRepository.save(course);

        return new Add_Review_Response("Success",review.getReviewId(), review.getReview_description(), review.getDate_time(), review.getCourseId(), course.getCourseName());

    }

    @Override
    public Review getReviewById(long review_id) {
        return null;
    }

    @Override
    public List<Review> getReviewsByCourseId(long course_id) {
        return null;
    }

    @Override
    public Review updateReview(Review review, long review_id) {
        return null;
    }

    @Override
    public void deleteReview(long review_id) {

    }

    @Override
    public List<Review> getReviews(long course_id) {

        Optional<Course> course = courseRepository.findById(course_id);

        if(!course.isPresent())
            throw  new ResourceNotFoundException("UnSuccess! Course not found with course id "+ course_id);

        List<Review> review_list = this.reviewRepository.getReviewList(course_id);

        return review_list;

    }
}
