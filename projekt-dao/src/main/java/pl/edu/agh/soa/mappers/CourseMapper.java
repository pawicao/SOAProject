package pl.edu.agh.soa.mappers;

import pl.edu.agh.soa.entities.CourseEntity;
import pl.edu.agh.soa.models.Course;

public class CourseMapper{

    public static CourseEntity modelToEntity(Course course) {
        return new CourseEntity(course.getName(), course.getEcts());
    }

    public static Course entityToModel(CourseEntity courseEntity) {
        return new Course(courseEntity.getName(), courseEntity.getEcts());
    }
}
