package com.example.udemybackendproject.model.user_course;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Add_User_in_Course_RT {

    long user_id;
    long course_id;

    public Add_User_in_Course_RT() {
    }

    public Add_User_in_Course_RT(long user_id, long course_id) {
        this.user_id = user_id;
        this.course_id = course_id;
    }
}
