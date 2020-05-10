package pl.egu.agh.soa.consume;

import pl.egu.agh.soa.*;

import javax.xml.ws.BindingProvider;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class SOAPConsumer {
    private final static String CLIMethodSeperator = "\n=============";

    private StudentServiceService studentService;
    private StudentService studentServicePort;

    private String username = "";
    private String password = "";

    public SOAPConsumer() {
        studentService = new StudentServiceService();
        studentServicePort = studentService.getStudentServicePort();
    }

    public SOAPConsumer(String username, String password) {
        studentService = new StudentServiceService();
        studentServicePort = studentService.getStudentServicePort();
        this.username = username;
        this.password = password;
    }

    private void authorize() {
        Map<String, Object> reqContext = ((BindingProvider)
                studentServicePort).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, this.username);
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, this.password);
    }

    public static void consume() {
        //String encodedAvatar = studentServicePort.getBase64Avatar(297270);
        //studentServicePort.addStudent(1,"Jan", "Kowalski",
          //      24,"EAIiIB");


        //try (FileOutputStream fos = new FileOutputStream("/decodedImage.jpg")) {
            //byte[] imageByteArray = Base64.getDecoder().decode(encodedAvatar);
          //  fos.write(imageByteArray);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

    }

    public List<Student> getAllStudents() {
        System.out.println(CLIMethodSeperator);
        System.out.println("SHOWING ALL STUDENTS:");
        return studentServicePort.getAllStudents().getStudent();
    }

    public List<Student> getAllStudentsByFaculty(String faculty) {
        System.out.println(CLIMethodSeperator);
        System.out.println("SHOWING ALL STUDENTS BY FACULTY " + faculty + ":");
        return studentServicePort.getStudentsByFaculty(faculty).getStudent();
    }

    public Student getStudentByIdx(int idx) {
        System.out.println(CLIMethodSeperator);
        System.out.println("SHOWING STUDENT " + idx + ":");
        return studentServicePort.getStudentByIdx(idx);
    }

    public byte[] getStudentAvatar(int idx) {
        String encodedAvatar = studentServicePort.getBase64Avatar(297270);
        return Base64.getDecoder().decode(encodedAvatar);
    }

    public Student editStudent(Student student) {
        System.out.println(CLIMethodSeperator);
        System.out.println("EDITING STUDENT " + student.getIdx() + ":");
        return studentServicePort.
                updateStudent(student.getIdx(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge(),
                        student.getFaculty()
                );
    }

    public String deleteStudent(int idx) {
        System.out.println(CLIMethodSeperator);
        System.out.println("DELETING STUDENT " + idx + ":");
        if(studentServicePort.deleteStudent(idx))
            return "Student "+idx+ " deleted successfully.";
        return "Student "+idx+ " did not get deleted.";
    }

    public Student addStudent(String firstName, String lastName, int idx, String faculty, int age) {
        System.out.println(CLIMethodSeperator);
        System.out.println("ADDING STUDENT " + idx + ":");
        return studentServicePort.addStudent(idx, firstName,lastName, age, faculty);
    }

    private String showStudent(Student student) {
        StringBuilder result = new StringBuilder(student.getFirstName() + ' ' +
                student.getLastName() + '(' + student.getIdx() + ')');
        result.append("\n\tAge: ").append(student.getAge());
        result.append("\n\tFaculty: ").append(student.getFaculty());
        result.append("\n\tAvatar filepath: ").append(student.getAvatarFilePath());
        result.append("\n\tCourses:\n");
        result.append(showCourses(student));
        return result.toString();
    }

    private String showCourses(Student student) {
        StringBuilder result = new StringBuilder();
        Student.Courses courses = student.getCourses();
        if (courses.getCourse().isEmpty())
            return "\t\tNONE";
        for(Course course : courses.getCourse()) {
            result.append("\t\t").append(course.getName()).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {

        // Creating consumer with proper credentials and authorizing
        SOAPConsumer consumer = new SOAPConsumer("admin1", "password");
        consumer.authorize();

        // Get all students
        for(Student student : consumer.getAllStudents()) {
            System.out.println(consumer.showStudent(student));
        }

        // Get all students by faculty
        for(Student student : consumer.getAllStudentsByFaculty("EAIiIB")) {
            System.out.println(consumer.showStudent(student));
        }

        // Get one student
        Student student = consumer.getStudentByIdx(297270);
        System.out.println(consumer.showStudent(student));

        // Get Student Base64 Avatar
        byte[] avatar = consumer.getStudentAvatar(297270);
        System.out.println("Avatar byte array size: " + avatar.length);

        // Edit student
        student.setFirstName("WcaleNieOskar");
        System.out.println(consumer.showStudent(consumer.editStudent(student)));

        // Delete student
        System.out.println(consumer.deleteStudent(297270));

        // Add student
        System.out.println(consumer.showStudent(consumer.
                addStudent("Maciej", "Maciejowski", 113113, "WMS", 19)
                )
        );

        // Show all students (to show the deletion of one student and the other student added)
        for(Student st : consumer.getAllStudents()) {
            System.out.println(consumer.showStudent(st));
        }

    }
}
