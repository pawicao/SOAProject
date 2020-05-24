package pl.edu.agh.soa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import pl.edu.agh.soa.embeddables.Faculty;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name = "students")
public class StudentEntity {

    @Id
    @Column(name = "idx")
    private int idx;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_attendee",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<CourseEntity> courses;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "faculty"))})
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dorm_id")
    private DormitoryEntity dormitory;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<PublicationEntity> publications;

    @JsonIgnoreProperties({"members" })
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "organization_member",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id"))
    private Set<OrganizationEntity> organizations;

    public StudentEntity() {
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public DormitoryEntity getDormitory() {
        return dormitory;
    }

    public void setDormitory(DormitoryEntity dormitory) {
        this.dormitory = dormitory;
    }

    public Set<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseEntity> courses) {
        this.courses = courses;
    }

    public Set<OrganizationEntity> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<OrganizationEntity> organizations) {
        this.organizations = organizations;
    }

    public Set<PublicationEntity> getPublications() {
        return publications;
    }

    public void setPublications(Set<PublicationEntity> publications) {
        this.publications = publications;
    }
}
