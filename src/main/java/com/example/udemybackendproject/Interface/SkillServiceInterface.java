package com.example.udemybackendproject.Interface;

import com.example.udemybackendproject.entities.Skill;
import com.example.udemybackendproject.model.skill.Add_Skill_Request;
import com.example.udemybackendproject.model.skill.Add_Skill_Response;

import java.util.Set;

public interface SkillServiceInterface {
    Add_Skill_Response addUserSkill(Add_Skill_Request add_skill_request);
    Set<Skill> getUserSkills(long userId);
}
