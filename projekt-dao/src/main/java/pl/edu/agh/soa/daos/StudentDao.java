package pl.edu.agh.soa.daos;

import pl.edu.agh.soa.embeddables.Faculty;
import pl.edu.agh.soa.entities.CourseEntity;
import pl.edu.agh.soa.entities.OrganizationEntity;
import pl.edu.agh.soa.entities.PublicationEntity;
import pl.edu.agh.soa.entities.StudentEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Organization;
import pl.edu.agh.soa.models.Publication;
import pl.edu.agh.soa.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class StudentDao {

    @PersistenceContext(unitName = "students")
    private EntityManager manager;

    public void create(Student student) {
        manager.persist(StudentDao.modelToEntity(student));
    }

    public void remove(Integer id) throws javassist.NotFoundException {
        StudentEntity found = manager.find(StudentEntity.class, id);
        if(found == null)
            throw new javassist.NotFoundException("Not found");
        else
            manager.remove(found);
    }

    public void update(Student student) throws IllegalArgumentException {
        manager.merge(StudentDao.modelToEntity(student));
    }

    public Student findById(Integer id) throws javassist.NotFoundException {
        StudentEntity found = manager.find(StudentEntity.class, id);
        if(found == null)
            throw new javassist.NotFoundException("Not found");
        return StudentDao.entityToModel(found);
    }

    public List<Student> findAll(Map<String, String> params) {
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
        List<StudentEntity> resultList = query.getResultList();
        if(resultList == null)
            return null;
        return resultList.stream().map(StudentDao::entityToModel).collect(Collectors.toList());
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

    public void flush() {
        manager.flush();
    }

    public static StudentEntity modelToEntity(Student student) {
        Set<CourseEntity> courseEntitySet = new HashSet<>();
        for(Course course : student.getCourses()) {
            courseEntitySet.add(CourseDao.modelToEntity(course));
        }
        Set<OrganizationEntity> organizationEntitySet = new HashSet<>();
        for(Organization organization : student.getOrganizations()) {
            organizationEntitySet.add(OrganizationDao.modelToEntity(organization));
        }
        Set<PublicationEntity> publicationEntitySet = new HashSet<>();
        for(Publication publication : student.getPublications()) {
            publicationEntitySet.add(PublicationDao.modelToEntity(publication));
        }

        StudentEntity studentEntity = new StudentEntity();
        if(student.getAge() != null ) studentEntity.setAge(student.getAge());
        if(student.getFaculty() != null) studentEntity.setFaculty(new Faculty(student.getFaculty()));
        studentEntity.setIdx(student.getIdx());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setCourses(courseEntitySet);
        studentEntity.setPublications(publicationEntitySet);
        studentEntity.setOrganizations(organizationEntitySet);
        studentEntity.setDormitory(DormitoryDao.modelToEntity(student.getDormitory()));
        return studentEntity;
    }

    public static Student entityToModel(StudentEntity studentEntity) {
        Student student;
        List<Course> courses = new ArrayList<>();
        for(CourseEntity courseEntity : studentEntity.getCourses()) {
            courses.add(CourseDao.entityToModel(courseEntity));
        }
        List<Organization> organizations = new ArrayList<>();
        for(OrganizationEntity organizationEntity : studentEntity.getOrganizations()) {
            organizations.add(OrganizationDao.entityToModel(organizationEntity));
        }
        List<Publication> publications = new ArrayList<>();
        for(PublicationEntity publicationEntity : studentEntity.getPublications()) {
            publications.add(PublicationDao.entityToModel(publicationEntity));
        }

        student = new Student(
                studentEntity.getFirstName(),
                studentEntity.getLastName(),
                studentEntity.getAge(),
                studentEntity.getFaculty() == null ? null : studentEntity.getFaculty().getName(),
                studentEntity.getIdx(),
                courses
        );
        student.setDormitory(DormitoryDao.entityToModel(studentEntity.getDormitory()));
        student.setOrganizations(organizations);
        student.setPublications(publications);

        return student;
    }

}
