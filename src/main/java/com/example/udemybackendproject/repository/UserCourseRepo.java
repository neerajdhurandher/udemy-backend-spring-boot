package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.model.course.Course_Response;
import com.example.udemybackendproject.model.user_course.Enrolled_Courses_by_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCourseRepo extends JpaRepository<Enrolled_Courses_by_User,Long> {
    @Query(nativeQuery = true)
    List<Course_Response> findAllEnrolledCoursesByUserId(long userId);
}
