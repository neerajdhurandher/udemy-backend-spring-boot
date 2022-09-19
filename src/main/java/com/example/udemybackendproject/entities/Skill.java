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
    private long skillId;
    private long userId;
    private String skillTitle;
    private int totalExperience;

    public Skill() {
    }

    public Skill(String skillTitle, int totalExperience, long userId) {
        this.skillTitle = skillTitle;
        this.totalExperience = totalExperience;
        this.userId = userId;
    }
}
