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
    private long user_id;
    private String name;
    private String email;
    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    @JsonIgnore
    private Set<Skill> skills;


    public User() {
    }

    public User(long user_id, String name, String email, int age) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
