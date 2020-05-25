package pl.edu.agh.soa.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"idx", "firstName", "lastName", "avatarFilePath", "age", "faculty",
        "courses", "dormitory", "organizations", "publications"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Student {

    private static String defaultAvatarPath = "defaultAvatar.jpg";

    private int idx;
    private String firstName;
    private String lastName;
    private String avatarFilePath;
    private Integer age;
    private String faculty;

    private List<Course> courses = new ArrayList<>();
    private List<Organization> organizations = new ArrayList<>();
    private List<Publication> publications = new ArrayList<>();
    private Dormitory dormitory = null;

    public Student(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        avatarFilePath = Student.defaultAvatarPath;
    }

    public Student(String firstName, String lastName, Integer age, String faculty) {
        this(firstName, lastName, age);
        this.faculty = faculty;
    }

    public Student(String firstName, String lastName, Integer age, String faculty, int idx) {
        this(firstName, lastName, age, faculty);
        this.idx = idx;
    }

    public Student(String firstName, String lastName, Integer age, String faculty, int idx, List<Course> courses) {
        this(firstName, lastName, age, faculty, idx);
        this.courses = courses;
    }

    public Student(String firstName, String lastName, Integer age, String faculty, int idx, List<Course> courses,
                   Dormitory dormitory) {
        this(firstName, lastName, age, faculty, idx, courses);
        this.dormitory = dormitory;
    }

    public Student(String firstName, String lastName, Integer age, String faculty, int idx, List<Course> courses,
                   List<Organization> organizations) {
        this(firstName, lastName, age, faculty, idx, courses);
        this.organizations = organizations;
    }

    public Student(String firstName, String lastName, Integer age, String faculty, int idx, List<Course> courses,
                   List<Organization> organizations, List<Publication> publications) {
        this(firstName, lastName, age, faculty, idx, courses, organizations);
        this.publications = publications;
    }

    public Student() {
        //No-arg constructor is just to keep JAXB from complaining
    }

    public boolean addCourse(String courseName) {
        Course course = Course.courses.get(courseName);
        if (course == null) {
            course = new Course(courseName);
            Course.courses.put(courseName, course);
            return courses.add(course);
        }
        return courses.add(course);
    }

    public boolean addCourse(Course course) {
        Course resCourse = Course.courses.get(course.getName());
        if (resCourse == null) {
            Course.courses.put(course.getName(), course);
            return courses.add(course);
        }
        courses.add(course);
        return true;
    }

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    @JsonProperty("courses")
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

    @XmlElement
    public Integer getIdx() {
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

    @XmlElement
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(firstName + ' ' + lastName + '(' + idx + ')');
        result.append("\n\tAge: ").append(age);
        result.append("\n\tFaculty: ").append(faculty);
        result.append("\n\tAvatar filepath: ").append(avatarFilePath);
        if(dormitory != null)
            result.append("\n\tDormitory: ").append(dormitory.getName());
        if(!courses.isEmpty()) {
            result.append("\n\tCourses:\n");
            for (Course course : courses) {
                result.append("\t\t").append(course.getName()).append('\n');
            }
        }
        if(!organizations.isEmpty()) {
            result.append("\tOrganizations:\n");
            for (Organization organization : organizations) {
                result.append("\t\t").append(organization.getName()).append('\n');
            }
        }
        if(!publications.isEmpty()) {
            result.append("\n\tPublications:\n");
            for (Publication publication : publications) {
                result.append("\t\t").append(publication.getName()).append('\n');
            }
        }
        return result.toString();
    }
}