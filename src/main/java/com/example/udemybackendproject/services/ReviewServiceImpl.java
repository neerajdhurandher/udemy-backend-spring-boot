package com.example.udemybackendproject.services;

import com.example.udemybackendproject.Interface.ReviewServiceInterface;
import com.example.udemybackendproject.entities.Course;
import com.example.udemybackendproject.entities.Review;
import com.example.udemybackendproject.model.review.Add_Review_Response;
import com.example.udemybackendproject.model.review.Add_Review_Request;
import com.example.udemybackendproject.repository.CourseRepository;
import com.example.udemybackendproject.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewServiceInterface {

    private final ReviewRepository reviewRepository;
    private final CourseRepository courseRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CourseRepository courseRepository){
        super();
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
    }


    @Override
    public Add_Review_Response addReview(Add_Review_Request add_reviewRequest) {

        Optional<Course> Ocourse = courseRepository.findById(add_reviewRequest.getCourse_id());

        if(Ocourse.isEmpty())
            throw new RuntimeException("Course not found");

        Course course = Ocourse.get();

        Review review = new Review(add_reviewRequest.getCourse_id(), add_reviewRequest.getUser_id(), add_reviewRequest.getReview_description());

        course.getReview_list().add(review);

        this.reviewRepository.save(review);
        this.courseRepository.save(course);

        return new Add_Review_Response("Success",review.getReview_id(), review.getReview_description(), review.getDate_time(), review.getCourse_id(), course.getCourse_name());

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

        System.out.println("neeraj " + course_id);

//        List<Get_Review_Response> review_list = this.reviewRepository.getReviewList(course_id);
        List<Review> review_list = this.reviewRepository.getReviewList(course_id);

        System.out.println(review_list);

        return review_list;

    }
}
