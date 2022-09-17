package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.model.user_course.Enrolled_User_in_Course;
import com.example.udemybackendproject.model.user.User_Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseUserRepo extends JpaRepository<Enrolled_User_in_Course,Long> {
    @Query(nativeQuery = true)
    List<User_Response> findAllEnrolledUsersByCourseId(long course_id);
}
