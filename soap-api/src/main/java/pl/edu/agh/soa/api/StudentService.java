package pl.edu.agh.soa.api;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.jws.WebParam;
import javax.xml.bind.annotation.*;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


// TODO: Security domain, secured methods and permission for all the other methods
@Stateless
@WebService
@WebContext(contextRoot = "/soa", urlPattern = "/studentService")
public class StudentService {

    //private StudentList students = new StudentList();
    private StudentList students = StudentList.createSampleList();

    @WebMethod
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getAllStudents() {
        return students.getAllStudents();
    }

    @WebMethod
    @XmlElement(name = "student")
    public Student getStudentByIdx(@WebParam(name = "idx") int idx) {
        return students.getStudentByIdx(idx);
    }

    @WebMethod
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentsByFirstName(@WebParam(name = "firstName") String firstName) {
        return students.getStudentsByFirstName(firstName);
    }

    @WebMethod
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentsByLastName(@WebParam(name = "lastName") String lastName) {
        return students.getStudentsByLastName(lastName);
    }

    @WebMethod
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentsByFaculty(@WebParam(name = "faculty") String faculty) {
        return students.getStudentsByFaculty(faculty);
    }

    @WebMethod
    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    public List<Course> getStudentsCourses(@WebParam(name = "idx") int idx) {
        Student student = students.getStudentByIdx(idx);
        if (student == null)
            return new ArrayList<>();
        return students.getStudentsCourses(student);
    }

    @WebMethod
    @XmlElement(name = "student")
    public Student addStudent(@WebParam(name = "idx") int idx, @WebParam(name = "firstName") String firstName,
                              @WebParam(name = "lastName") String lastName, @WebParam(name = "age") int age,
                              @WebParam(name = "faculty") String faculty) {
        Student newStudent = null;
        if(students.getStudentByIdx(idx) == null) {
            newStudent = new Student(firstName, lastName, age, faculty, idx);
            students.addStudent(newStudent);
        }
        return newStudent;
    }

    @WebMethod
    public boolean deleteStudent(@WebParam(name = "idx") int idx) {
        return students.deleteStudent(idx);
    }

    @WebMethod
    public Student updateStudent(@WebParam(name = "idx") int idx, @WebParam(name = "firstName") String firstName,
                              @WebParam(name = "lastName") String lastName, @WebParam(name = "age") int age,
                              @WebParam(name = "faculty") String faculty) {
        Student student = students.getStudentByIdx(idx);
        if(student == null) {
            return student;
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setFaculty(faculty);
        return student;
    }
}
