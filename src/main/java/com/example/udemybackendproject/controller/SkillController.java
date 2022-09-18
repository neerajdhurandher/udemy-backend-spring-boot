package com.example.udemybackendproject.controller;

import com.example.udemybackendproject.entities.Skill;
import com.example.udemybackendproject.model.skill.Add_Skill_Request;
import com.example.udemybackendproject.model.skill.Add_Skill_Response;
import com.example.udemybackendproject.services.SkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class SkillController {

    @Autowired
    private SkillServiceImpl skillService;

    @PostMapping("/add-skill")
    public ResponseEntity<Add_Skill_Response> addUserSkill(@RequestBody Add_Skill_Request add_skill_request){
        return new ResponseEntity<>(skillService.addUserSkill(add_skill_request), HttpStatus.CREATED);
    }

    @GetMapping("/get-usre-skills/{id}")
    public ResponseEntity<Set<Skill>> getUserSkills(@PathVariable(value = "id") long userId){
        return new ResponseEntity<>(skillService.getUserSkills(userId), HttpStatus.OK);
    }
}
