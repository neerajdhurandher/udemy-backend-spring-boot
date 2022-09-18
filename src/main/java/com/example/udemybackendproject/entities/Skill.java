package com.example.udemybackendproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long skill_id;
    private long user_id;
    private String skill_title;
    private int totalExperience;

    public Skill() {
    }

    public Skill(String skill_title, int totalExperience, long user_id) {
        this.skill_title = skill_title;
        this.totalExperience = totalExperience;
        this.user_id = user_id;
    }
}
