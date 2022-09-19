package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findUserByNameStartingWith(String nameKeyword);
}
