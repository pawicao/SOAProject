package pl.edu.agh.soa.api;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private int idx;
    private String firstName;
    private String lastName;
    private String avatarFilePath;
    private int age;
    private String faculty;

    private List<Course> courses = new ArrayList<>();

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(String firstName, String lastName, int age, String faculty) {
        this(firstName, lastName, age);
        this.faculty = faculty;
    }

    public Student(String firstName, String lastName, int age, String faculty, int idx) {
        this(firstName, lastName, age, faculty);
        this.idx = idx;
    }

    public boolean addCourse(String courseName) {
        Course course = Course.courses.get(courseName);
        if(course == null) {
            course = new Course(courseName);
            Course.courses.put(courseName, course);
            return courses.add(course);
        }
        return courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getAvatarFilePath() {
        return avatarFilePath;
    }

    public void setAvatarFilePath(String avatarFilePath) {
        this.avatarFilePath = avatarFilePath;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}