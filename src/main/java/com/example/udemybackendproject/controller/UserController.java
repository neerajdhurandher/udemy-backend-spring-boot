package com.example.udemybackendproject.controller;

import com.example.udemybackendproject.entities.Course;
import com.example.udemybackendproject.entities.User;
import com.example.udemybackendproject.model.course.Course_Response;
import com.example.udemybackendproject.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-user/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") long userId, @RequestBody  User user){
        return new ResponseEntity<>(userService.updateUser(user,userId), HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable(value = "id") long userId){
        userService.deleteUser(userId);
    }

    @GetMapping("/get-user-courses/{id}")
    public ResponseEntity<List<Course_Response>> getUserCourse(@PathVariable(value = "id") long userId){
        return new ResponseEntity<>(userService.getUserCourse(userId), HttpStatus.OK);
    }

    @RequestMapping("/demo")
    @ResponseBody
    public String demoFun(){
        return "Demo JSP";
    }
}
