package com.example.udemybackendproject.model.user_course;

import com.example.udemybackendproject.model.user.User_Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedNativeQuery(name = "Enrolled_User_in_Course.findAllEnrolledUsersByCourseId",query = " SELECT user.*,enrolled_user_in_course.course_id from (udemybackend.enrolled_user_in_course inner join udemybackend.user ON user.user_id = enrolled_user_in_course.user_id) where enrolled_user_in_course.course_id = :courseId ", resultSetMapping = "Mapping.User_Response")

@SqlResultSetMapping(name = "Mapping.User_Response",
        classes = @ConstructorResult(targetClass = User_Response.class,
                columns = {
                        @ColumnResult(name = "user_id",type=long.class),
                        @ColumnResult(name = "name",type=String.class),
                        @ColumnResult(name = "email",type=String.class),
                        @ColumnResult(name = "age",type=int.class)
                }
        ))

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrolled_User_in_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long courseUserId;
    long courseId;
    long userId;

    public Enrolled_User_in_Course(long courseId, long userId) {
        this.courseId = courseId;
        this.userId = userId;
    }
}
