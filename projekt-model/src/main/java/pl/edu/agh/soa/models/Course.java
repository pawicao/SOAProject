package pl.edu.agh.soa.models;

import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

@XmlType(propOrder={"name","ects"})
public class Course {
    private String name;
    private int ects;

    public Course(String name, int ects) {
        this.name = name;
        this.ects = ects;
    }

    public Course(String name) {
        this.name = name;
        this.ects = 0;
    }

    public Course() {
        //No-arg constructor is just to keep JAXB from complaining
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }


    static Map<String, Course> courses = new HashMap<>();
    public static Course createCourse(String name, int ects) {
        Course course = new Course(name, ects);
        courses.put(name, course);
        return course;
    }
}
