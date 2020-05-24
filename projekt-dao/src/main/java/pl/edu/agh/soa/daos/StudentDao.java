package pl.edu.agh.soa.daos;

import pl.edu.agh.soa.entities.StudentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        Root<StudentEntity> s = criteriaQuery.from(StudentEntity.class);
        if(params.isEmpty()) {
            criteriaQuery.select(s);
        }
        else {
            criteriaQuery.select(s).where(processParameters(builder, s, params));
        }
        TypedQuery<StudentEntity> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private Predicate[] processParameters(CriteriaBuilder builder, Root<StudentEntity> s, Map<String, String> params) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        for(Map.Entry<String, String> param : params.entrySet()) {
            predicates.add(builder.equal(s.get(param.getKey()), param.getValue()));
        }
        return predicates.toArray(new Predicate[]{});
    }

}
