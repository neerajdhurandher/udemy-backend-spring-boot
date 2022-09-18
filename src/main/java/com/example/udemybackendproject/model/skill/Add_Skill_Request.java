package com.example.udemybackendproject.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Add_Skill_Request {
    long user_id;
    String skill_title;
    private int totalExperience;
}
