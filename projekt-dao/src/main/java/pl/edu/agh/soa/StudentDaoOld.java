package pl.edu.agh.soa;

import pl.edu.agh.soa.entities.StudentEntity;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class StudentDaoOld extends DaoOld {

    private static final Logger LOGGER = Logger.getLogger(StudentDaoOld.class.getName());

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<StudentEntity> getType() {
        return StudentEntity.class;
    }
}
