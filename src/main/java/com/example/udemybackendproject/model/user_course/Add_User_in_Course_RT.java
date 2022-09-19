package com.example.udemybackendproject.model.user_course;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Add_User_in_Course_RT {

    long userId;
    long courseId;

    public Add_User_in_Course_RT() {
    }

    public Add_User_in_Course_RT(long userId, long courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }
}
