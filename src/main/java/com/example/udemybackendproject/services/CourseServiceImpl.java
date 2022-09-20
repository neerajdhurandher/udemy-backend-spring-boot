package com.example.udemybackendproject.services;

import com.example.udemybackendproject.Interface.CourseServiceInterface;
import com.example.udemybackendproject.entities.Course;
import com.example.udemybackendproject.model.general.General_Response;
import com.example.udemybackendproject.model.user_course.Enrolled_User_in_Course;
import com.example.udemybackendproject.entities.User;
import com.example.udemybackendproject.exceptions.ResourceNotFoundException;
import com.example.udemybackendproject.model.course.Update_Course_Request;
import com.example.udemybackendproject.model.course.Update_Course_Response;
import com.example.udemybackendproject.model.user.User_Response;
import com.example.udemybackendproject.model.user_course.Add_User_in_Course_RP;
import com.example.udemybackendproject.model.user_course.Add_User_in_Course_RT;
import com.example.udemybackendproject.model.course.Course_Response;
import com.example.udemybackendproject.repository.CourseRepository;
import com.example.udemybackendproject.repository.CourseUserRepo;
import com.example.udemybackendproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseServiceInterface {


    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseUserRepo courseUserRepo;

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository, CourseUserRepo courseUserRepo){
        super();
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.courseUserRepo = courseUserRepo;
    }
    @Override
    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course_Response getCourseById(long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()) {
            Course result_course = course.get();
            return  new Course_Response(result_course.getCourseId(),result_course.getCourseName(),result_course.getDomain(),result_course.getAuthorId(),result_course.getDuration(),result_course.getRating(),result_course.getPrice());
        }
        else
            throw  new ResourceNotFoundException("UnSuccess! Course not found with course id "+ courseId);
    }

    @Override
    public List<Course> getCourseByName(String search_keyword) {
        List<Course> result = courseRepository.findCourseByCourseNameStartingWith(search_keyword);

        if(result.isEmpty())
            throw  new ResourceNotFoundException("UnSuccess! Course not found with keyword "+ search_keyword);

        return result;

    }

    @Override
    public Update_Course_Response updateCourse(Update_Course_Request ur_course) {

        Optional<Course> course_o = courseRepository.findById(ur_course.getCourseId());

        if(!course_o.isPresent())
            throw  new ResourceNotFoundException("UnSuccess! Course not found with course id "+ ur_course.getCourseId());

        Course course = course_o.get();

        if(ur_course.getCourseName() != null){
           course.setCourseName(ur_course.getCourseName());
        }
        if(ur_course.getDomain() != null){
            course.setDomain(ur_course.getDomain());
        }
        if(ur_course.getDuration() > 0 ){
            course.setDuration(ur_course.getDuration());
        }
        if(ur_course.getPrice() > 0 ){
            course.setPrice(ur_course.getPrice());
        }

        this.courseRepository.save(course);

        return new Update_Course_Response("Success", course.getCourseId(), course.getCourseName(), course.getDomain(), course.getAuthorId(), course.getDuration(), course.getPrice());


    }

    @Override
    public General_Response deleteCourse(long course_id) {
        courseRepository.findById(course_id).orElseThrow( () -> new ResourceNotFoundException("Can't delete due to Course not found with course id "+ course_id));
        courseRepository.deleteById(course_id);
        return new General_Response("Success","Delete Course with course id "+ course_id, LocalDateTime.now(), "/delete-course/{course_id}");
    }

    // enroll a user into a course
    @Override
    public Add_User_in_Course_RP enrollUser(Add_User_in_Course_RT add_user_in_course_request) {

        long course_id = add_user_in_course_request.getCourseId();
        long user_id = add_user_in_course_request.getUserId();

        Optional<Course> course_o = courseRepository.findById(course_id);

        if(!course_o.isPresent())
            throw  new ResourceNotFoundException("UnSuccess! Course not found with course id "+ course_id);


        Optional<User> user = userRepository.findById(user_id);

        if(!user.isPresent())
            throw  new ResourceNotFoundException("UnSuccess! User not found with user id "+ user_id);

        Course course = course_o.get();

        this.courseUserRepo.save(new Enrolled_User_in_Course(course_id,user_id));

        return new Add_User_in_Course_RP("Success",user_id,course_id);
    }

    // get all enrolled user details
    @Override
    public List<User_Response> getEnrolledUsers(long course_id) {
         Optional<Course> course = courseRepository.findById(course_id);

        if(!course.isPresent())
            throw  new ResourceNotFoundException("UnSuccess! Course not found with course id "+ course_id);

//        findAllByCourseId use native query and get user details using user id
        List<User_Response> enrolled_users_list = this.courseUserRepo.findAllEnrolledUsersByCourseId(course_id);

        return enrolled_users_list;
    }
}
