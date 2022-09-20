package com.example.udemybackendproject.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Add_Skill_Response {
    String message;
    long userId;
    String userName;
    String skillTitle;
    private int totalExperience;

}
