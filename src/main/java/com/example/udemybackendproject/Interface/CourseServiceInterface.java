package com.example.udemybackendproject.Interface;

import com.example.udemybackendproject.entities.Course;
import com.example.udemybackendproject.model.course.Update_Course_Request;
import com.example.udemybackendproject.model.course.Update_Course_Response;
import com.example.udemybackendproject.model.general.General_Response;
import com.example.udemybackendproject.model.user.User_Response;
import com.example.udemybackendproject.model.user_course.Add_User_in_Course_RP;
import com.example.udemybackendproject.model.user_course.Add_User_in_Course_RT;
import com.example.udemybackendproject.model.course.Course_Response;

import java.util.List;

public interface CourseServiceInterface {
    Course addCourse(Course course);
    List<Course> getAllCourses();
    Course_Response getCourseById(long course_id);
    List<Course> getCourseByName(String nameKeyword);
    Update_Course_Response updateCourse(Update_Course_Request update_course_request);
    General_Response deleteCourse(long course_id);

    Add_User_in_Course_RP enrollUser(Add_User_in_Course_RT add_user_in_course_request);

    List<User_Response> getEnrolledUsers(long course_id);
}
