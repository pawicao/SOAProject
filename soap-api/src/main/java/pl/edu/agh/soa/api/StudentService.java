package pl.edu.agh.soa.api;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.models.StudentList;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.PermitAll;
import javax.jws.WebParam;
import javax.xml.bind.annotation.*;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Stateless
@SecurityDomain("students-project-domain")
@DeclareRoles({"ProjectGroup", "ProjectGroupAdmin"})
@WebService
@WebContext(contextRoot = "/soa", urlPattern = "/studentService", authMethod = "BASIC", transportGuarantee = "NONE")
public class StudentService {

    //private StudentList students = new StudentList();
    private StudentList students = StudentList.createSampleList();

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getAllStudents() {
        return students.getAllStudents();
    }

    @WebMethod
    @PermitAll
    @XmlElement(name = "student")
    public Student getStudentByIdx(@WebParam(name = "idx") int idx) {
        return students.getStudentByIdx(idx);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentsByFirstName(@WebParam(name = "firstName") String firstName) {
        return students.getStudentsByFirstName(firstName);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentsByLastName(@WebParam(name = "lastName") String lastName) {
        return students.getStudentsByLastName(lastName);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentsByFaculty(@WebParam(name = "faculty") String faculty) {
        return students.getStudentsByFaculty(faculty);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    public List<Student> getStudentsByAge(@WebParam(name = "age") int age) {
        return students.getStudentsByAge(age);
    }

    @WebMethod
    @PermitAll
    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    public List<Course> getStudentsCourses(@WebParam(name = "idx") int idx) {
        Student student = students.getStudentByIdx(idx);
        if (student == null)
            return new ArrayList<>();
        return student.getCourses();
    }

    @WebMethod
    @RolesAllowed("ProjectGroupAdmin")
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
    @RolesAllowed("ProjectGroupAdmin")
    public boolean deleteStudent(@WebParam(name = "idx") int idx) {
        return students.deleteStudent(idx);
    }

    @WebMethod
    @RolesAllowed("ProjectGroupAdmin")
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

    @WebMethod
    @PermitAll
    public String getBase64Avatar(@WebParam(name = "idx") int idx) {
        Student student = students.getStudentByIdx(idx);
        if(student ==  null)
            return null;
        String encodedFile = null;

        URL resource = getClass().getClassLoader().getResource("defaultAvatar.jpg");
        InputStream iStream = null;
        try {
            iStream = resource.openStream();
            int resourceSize = resource.openConnection().getContentLength();
            byte[] bytes = new byte[resourceSize];
            iStream.read(bytes);
            encodedFile = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            return e.toString();
        }
        return encodedFile;
    }
}