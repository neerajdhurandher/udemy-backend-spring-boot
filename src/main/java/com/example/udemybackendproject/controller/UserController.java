package com.example.udemybackendproject.controller;

import com.example.udemybackendproject.entities.User;
import com.example.udemybackendproject.model.course.Course_Response;
import com.example.udemybackendproject.model.general.General_Response;
import com.example.udemybackendproject.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-user/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "user_id") long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/get-user")
    public ResponseEntity<List<User>> getUserByName(@RequestParam String search_keyword){
        return new ResponseEntity<>(userService.getUserByName(search_keyword), HttpStatus.OK);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update-user/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "user_id") long userId, @RequestBody  User user){
        return new ResponseEntity<>(userService.updateUser(user,userId), HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{user_id}")
    public General_Response deleteUser(@PathVariable(value = "user_id") long userId){
        return userService.deleteUser(userId);
    }

    @GetMapping("/get-user-courses/{user_id}")
    public ResponseEntity<List<Course_Response>> getUserCourse(@PathVariable(value = "user_id") long userId){
        return new ResponseEntity<>(userService.getUserCourse(userId), HttpStatus.OK);
    }
}
