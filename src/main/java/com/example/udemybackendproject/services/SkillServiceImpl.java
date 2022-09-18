package com.example.udemybackendproject.services;

import com.example.udemybackendproject.Interface.SkillServiceInterface;
import com.example.udemybackendproject.entities.Skill;
import com.example.udemybackendproject.entities.User;
import com.example.udemybackendproject.exceptions.ResourceNotFoundException;
import com.example.udemybackendproject.model.skill.Add_Skill_Request;
import com.example.udemybackendproject.model.skill.Add_Skill_Response;
import com.example.udemybackendproject.repository.SkillRepository;
import com.example.udemybackendproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;
import java.util.Set;

@Service
public class SkillServiceImpl implements SkillServiceInterface {

    private final SkillRepository skillRepository;
    private final UserRepository userRepository;

    public SkillServiceImpl(SkillRepository skillRepository, UserRepository userRepository) {
        super();
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Add_Skill_Response addUserSkill(Add_Skill_Request add_skill_request) {

        Optional<User> user_o = userRepository.findById(add_skill_request.getUser_id());

        if(user_o.isEmpty())
            throw new ResourceNotFoundException("User not found with user id "+ add_skill_request.getUser_id());

        User user = user_o.get();

        Skill skill = new Skill(add_skill_request.getSkill_title().toLowerCase(Locale.ROOT),add_skill_request.getTotalExperience(),add_skill_request.getUser_id());

        this.skillRepository.save(skill);

        user.getSkills().add(skill);

        this.userRepository.save(user);

        return new Add_Skill_Response("Success",user.getUser_id(),user.getName(),add_skill_request.getSkill_title(),add_skill_request.getTotalExperience());
    }

    @Override
    public Set<Skill> getUserSkills(long userId) {
        Optional<User> user_o = userRepository.findById(userId);

        if(user_o.isEmpty())
            throw new ResourceNotFoundException("User not found with user id "+ userId);

        User user = user_o.get();

        return user.getSkills();
    }
}
