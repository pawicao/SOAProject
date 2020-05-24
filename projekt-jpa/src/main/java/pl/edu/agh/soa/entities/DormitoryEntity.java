package pl.edu.agh.soa.entities;

import javax.persistence.*;

@Entity
@Table(name = "dormitories")
public class DormitoryEntity {

    @GeneratedValue
    @Id
    @Column(name = "dorm_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public DormitoryEntity() {}

    public DormitoryEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
