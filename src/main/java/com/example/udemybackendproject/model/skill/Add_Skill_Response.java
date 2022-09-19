package com.example.udemybackendproject.model.skill;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Add_Skill_Response {
    String message;
    long user_id;
    String user_name;
    String skill_title;
    private int totalExperience;

}
