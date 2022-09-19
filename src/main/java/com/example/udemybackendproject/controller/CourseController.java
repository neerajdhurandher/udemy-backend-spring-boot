package com.example.udemybackendproject.controller;

import com.example.udemybackendproject.entities.Course;
import com.example.udemybackendproject.model.course.Course_Response;
import com.example.udemybackendproject.model.course.Update_Course_Request;
import com.example.udemybackendproject.model.course.Update_Course_Response;
import com.example.udemybackendproject.model.user.User_Response;
import com.example.udemybackendproject.model.user_course.Add_User_in_Course_RP;
import com.example.udemybackendproject.model.user_course.Add_User_in_Course_RT;
import com.example.udemybackendproject.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping("/add-course")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-course")
    public List<Course> getAllCourse(){
        return courseService.getAllCourses();
    }

    @GetMapping(value = "/get-course/{course_id}")
    public ResponseEntity<Course_Response> getCourseById(@PathVariable(value = "course_id") long courseId){
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }

    @GetMapping(value = "/get-course")
    public ResponseEntity<List<Course>> getCourseByName(@RequestParam String search_keyword){
        return new ResponseEntity<>(courseService.getCourseByName(search_keyword), HttpStatus.OK);
    }

    @PutMapping(value = "/update-course")
    public ResponseEntity<Update_Course_Response> updateCourse(@RequestBody Update_Course_Request update_course_request){
        return new ResponseEntity<>(courseService.updateCourse(update_course_request), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/enroll-user")
    public ResponseEntity<Add_User_in_Course_RP> enrollUser(@RequestBody Add_User_in_Course_RT add_user_in_course_request){
        return new ResponseEntity<>(courseService.enrollUser(add_user_in_course_request), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/get-enroll-users/{course_id}")
    public ResponseEntity<List<User_Response>> getEnrolledUsers(@PathVariable(value = "course_id") long courseId){
        return new ResponseEntity<>(courseService.getEnrolledUsers(courseId), HttpStatus.OK);
    }

}
