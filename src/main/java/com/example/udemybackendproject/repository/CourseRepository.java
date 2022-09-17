package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long>{

}
