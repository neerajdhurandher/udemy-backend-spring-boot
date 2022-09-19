package com.example.udemybackendproject.services;

import com.example.udemybackendproject.Interface.UserServiceInterface;
import com.example.udemybackendproject.entities.Skill;
import com.example.udemybackendproject.entities.User;
import com.example.udemybackendproject.exceptions.ResourceNotFoundException;
import com.example.udemybackendproject.model.course.Course_Response;
import com.example.udemybackendproject.model.skill.Add_Skill_Request;
import com.example.udemybackendproject.model.skill.Add_Skill_Response;
import com.example.udemybackendproject.repository.UserCourseRepo;
import com.example.udemybackendproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {

//    @Autowired // setter dependency injection
    private final UserRepository userRepository;
    private final UserCourseRepo userCourseRepo;

    // constructor dependency injection
    public UserServiceImpl(UserRepository userRepository, UserCourseRepo userCourseRepo) {
        super();
        this.userRepository = userRepository;
        this.userCourseRepo = userCourseRepo;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {

        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new ResourceNotFoundException("User not found with user id "+ userId));
    }

    @Override
    public List<User> getUserByName(String nameKeyword) {
        List<User> result = userRepository.findUserByNameStartingWith(nameKeyword);
        return result;
    }

    @Override
    public User updateUser(User user, long userId) {
        User getDbUser = userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("Can't update due to User not found with user id "+ userId));

        if(user.getName() != null)
            getDbUser.setName(user.getName());
        if(user.getEmail() != null)
            getDbUser.setEmail(user.getEmail());
        if(user.getAge() > 0)
            getDbUser.setAge(user.getAge());

        return userRepository.save(getDbUser);

    }

    @Override
    public void deleteUser(long userId) {
        userRepository.findById(userId).orElseThrow( () -> new ResourceNotFoundException("Can't delete due to User not found with user id "+ userId));
        userRepository.deleteById(userId);
    }

    @Override
    public List<Course_Response> getUserCourse(long userId) {

        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty())
            throw new ResourceNotFoundException("User not found with user id "+ userId);

        List<Course_Response> enrolled_courses_list = this.userCourseRepo.findAllEnrolledCoursesByUserId(userId);

        return enrolled_courses_list;
    }


}
