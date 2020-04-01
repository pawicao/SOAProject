package pl.edu.agh.soa.models;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder={"idx", "firstName", "lastName","avatarFilePath","age","faculty","courses"})
public class Student {
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

    public Student(String firstName, String lastName, int age, String faculty, int idx, List<Course> courses) {
        this(firstName, lastName, age, faculty, idx);
        this.courses = courses;
    }

    public Student() {
        //No-arg constructor is just to keep JAXB from complaining
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

    public boolean addCourse(Course course) {
        Course resCourse = Course.courses.get(course.getName());
        if(resCourse == null) {
            Course.courses.put(course.getName(), course);
            return courses.add(course);
        }
        courses.add(course);
        return true;
    }

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
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