package pl.edu.agh.soa.api;

import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.models.StudentList;

import javax.xml.bind.annotation.*;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService
// TODO: Security domain, secured methods and permission for all the other methods
public class StudentService {

    //private StudentList students = new StudentList();
    private StudentList students = StudentList.createSampleList();

    @WebMethod
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getAllStudents() {
        return students.getAllStudents();
    }
}
