package pl.edu.agh.soa.daos;

import pl.edu.agh.soa.entities.CourseEntity;
import pl.edu.agh.soa.models.Course;

public class CourseDao {

    public static CourseEntity modelToEntity(Course course) {
        return new CourseEntity(course.getName(), course.getEcts());
    }

    public static Course entityToModel(CourseEntity courseEntity) {
        return new Course(courseEntity.getName(), courseEntity.getEcts());
    }
}
