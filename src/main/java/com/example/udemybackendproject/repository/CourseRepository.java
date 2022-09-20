package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long>{
    List<Course> findCourseByCourseNameStartingWith(String course_name);
}
