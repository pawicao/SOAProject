package pl.edu.agh.soa.daos;

import pl.edu.agh.soa.entities.CourseEntity;
import pl.edu.agh.soa.entities.StudentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Stateless
public class StudentDao {

    @PersistenceContext(unitName = "students")
    private EntityManager manager;

    public void create(StudentEntity entity) {
        manager.persist(entity);
    }

    public void remove(StudentEntity entity) {
        manager.remove(entity);
    }

    public StudentEntity findById(Integer id) {
        return manager.find(StudentEntity.class, id);
    }

    public void flush() {
        manager.flush();
    }

    public List<StudentEntity> findAll(Map<String, String> params) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = builder.createQuery(StudentEntity.class);
        Root<StudentEntity> root = criteriaQuery.from(StudentEntity.class);
        if(params.isEmpty()) {
            criteriaQuery.select(root);
        }
        else {
            criteriaQuery.select(root).where(processParameters(builder, root, params));
        }
        TypedQuery<StudentEntity> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private Predicate[] processParameters(CriteriaBuilder builder, Root<StudentEntity> root, Map<String, String> params) {
        List<Predicate> predicates = new ArrayList<>();
        for(Map.Entry<String, String> param : params.entrySet()) {
            String key = param.getKey();
            switch(key) {
                case "courseName":
                case "course":
                    predicates.add(builder.equal(builder.lower(root.join("courses", JoinType.INNER).get("name"))
                            ,param.getValue().toLowerCase()));
                    break;
                case "courseId":
                    predicates.add(builder.equal(root.join("courses", JoinType.INNER).get("id"),
                            param.getValue()));
                    break;
                case "faculty":
                    predicates.add(builder.equal(builder.lower(root.get(key).get("name")),
                            param.getValue().toLowerCase()));
                    break;
                case "dormitory":
                    predicates.add(builder.equal(builder.lower(root.get(key).get("code")),
                            param.getValue().toLowerCase()));
                    break;
                case "organizationName":
                case "organization":
                    predicates.add(builder.equal(builder.lower(root.join("organizations",JoinType.INNER).get("name"))
                            ,param.getValue().toLowerCase()));
                    break;
                case "organizationId":
                    predicates.add(builder.equal(root.join("organizations", JoinType.INNER).get("id"),
                            param.getValue()));
                    break;
                default:
                    predicates.add(builder.equal(root.get(key), param.getValue()));
                    break;
            }
        }
        return predicates.toArray(new Predicate[]{});
    }

}
