package com.example.udemybackendproject.repository;

import com.example.udemybackendproject.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Long> {
}
