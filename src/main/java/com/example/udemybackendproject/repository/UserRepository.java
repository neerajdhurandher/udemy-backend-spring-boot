package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{

}
