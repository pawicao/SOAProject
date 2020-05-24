package pl.edu.agh.soa.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class CourseEntity {

    @GeneratedValue
    @Id
    @Column(name = "course_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "ects")
    private int ects;

    public CourseEntity() {}

    public CourseEntity(String name, int ects) {
        this.name = name;
        this.ects = ects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
