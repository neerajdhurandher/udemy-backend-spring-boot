package com.example.udemybackendproject.model.user_course;

import com.example.udemybackendproject.model.course.Course_Response;
import com.example.udemybackendproject.model.user.User_Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedNativeQuery(name = "Enrolled_Courses_by_User.findAllEnrolledCoursesByUserId", query = " SELECT course.*,enrolled_user_in_course.user_id from (udemybackend.enrolled_user_in_course inner join udemybackend.course ON course.course_id = enrolled_user_in_course.course_id) where enrolled_user_in_course.user_id = :user_id ", resultSetMapping = "Mapping.Course_Response")

@SqlResultSetMapping(name = "Mapping.Course_Response",
        classes = @ConstructorResult(targetClass = Course_Response.class,
                columns = {
                        @ColumnResult(name = "course_id",type=long.class),
                        @ColumnResult(name = "course_name",type=String.class),
                        @ColumnResult(name = "domain",type=String.class),
                        @ColumnResult(name = "author_id",type=long.class),
                        @ColumnResult(name = "duration",type=long.class),
                        @ColumnResult(name = "rating",type=double.class),
                        @ColumnResult(name = "price",type=int.class)
                }
        ))

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrolled_Courses_by_User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long courseUserId;
    long course_id;
    long user_id;

    public Enrolled_Courses_by_User(long course_id, long user_id) {
        this.course_id = course_id;
        this.user_id = user_id;
    }
}
