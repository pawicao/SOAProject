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
}
