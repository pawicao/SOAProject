package pl.edu.agh.soa.models;

import java.util.HashMap;
import java.util.Map;

public class Course {
    static Map<String, Course> courses = new HashMap<>();

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
}
