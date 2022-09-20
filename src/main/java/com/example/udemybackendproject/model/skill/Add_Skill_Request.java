package com.example.udemybackendproject.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Add_Skill_Request {
    long userId;
    String skillTitle;
    private int totalExperience;
}
