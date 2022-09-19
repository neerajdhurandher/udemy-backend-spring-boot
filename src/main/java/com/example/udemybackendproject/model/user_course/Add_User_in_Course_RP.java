package com.example.udemybackendproject.model.user_course;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Add_User_in_Course_RP {

    String status;
    long userId;
    long courseId;

    public Add_User_in_Course_RP() {
    }

    public Add_User_in_Course_RP(String status, long userId, long courseId) {
        this.status = status;
        this.userId = userId;
        this.courseId = courseId;
    }
}
