package pl.edu.agh.soa.mappers;

import pl.edu.agh.soa.entities.CourseEntity;
import pl.edu.agh.soa.entities.StudentEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentMapper {


    public static StudentEntity modelToEntity(Student student) {
        Set<CourseEntity> courseEntitySet = new HashSet<>();
        for(Course course : student.getCourses()) {
            courseEntitySet.add(CourseMapper.modelToEntity(course));
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setIdx(student.getIdx());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setCourses(courseEntitySet);
        return studentEntity;
    }

    public static Student entityToModel(StudentEntity studentEntity) {
        List<Course> courses = new ArrayList<>();
        for(CourseEntity courseEntity : studentEntity.getCourses()) {
            courses.add(CourseMapper.entityToModel(courseEntity));
        }
        return new Student(
                studentEntity.getFirstName(),
                studentEntity.getLastName(),
                studentEntity.getAge(),
                studentEntity.getFaculty().getName(),
                studentEntity.getIdx(),
                courses
        );
    }
}
