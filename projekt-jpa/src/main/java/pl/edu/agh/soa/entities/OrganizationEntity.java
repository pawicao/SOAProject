package pl.edu.agh.soa.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "organizations")
public class OrganizationEntity {

    @GeneratedValue
    @Id
    @Column(name = "organization_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_year")
    private int creationYear;

    @ManyToMany(mappedBy = "organizations", fetch = FetchType.EAGER)
    private Set<StudentEntity> members;

    public OrganizationEntity() {}

    public OrganizationEntity(String name, int creationYear) {
        this.name = name;
        this.creationYear = creationYear;
    }

    public OrganizationEntity(String name, int creationYear, Set<StudentEntity> members) {
        this.name = name;
        this.creationYear = creationYear;
        this.members = members;
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

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public Set<StudentEntity> getMembers() {
        return members;
    }

    public void setMembers(Set<StudentEntity> members) {
        this.members = members;
    }
}
