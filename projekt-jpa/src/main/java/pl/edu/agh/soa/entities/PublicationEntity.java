package pl.edu.agh.soa.entities;

import javax.persistence.*;

@Entity
@Table(name = "publications")
public class PublicationEntity {

    @GeneratedValue
    @Id
    @Column(name = "publication_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private StudentEntity student;

    public PublicationEntity() {}

    public PublicationEntity(String name) {
        this.name = name;
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

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
