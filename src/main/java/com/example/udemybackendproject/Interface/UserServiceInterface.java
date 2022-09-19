package com.example.udemybackendproject.Interface;

import com.example.udemybackendproject.entities.Course;
import com.example.udemybackendproject.entities.User;
import com.example.udemybackendproject.model.course.Course_Response;

import java.util.List;

public interface UserServiceInterface {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    List<User> getUserByName(String nameKeyword);
    User updateUser(User user, long id);
    void deleteUser(long id);

    List<Course_Response> getUserCourse(long userId);
}
