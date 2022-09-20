package com.example.udemybackendproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String name;
    private String email;
    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "userIdFk", referencedColumnName = "userId")
    @JsonIgnore
    private Set<Skill> skills;


    public User() {
    }

    public User(long userId, String name, String email, int age) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
