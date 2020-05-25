package pl.edu.agh.soa.consume;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.models.StudentList;
import pl.edu.agh.soa.models.StudentProto;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class RESTConsumer {
    private final static String authorizationEndpoint = "http://localhost:8080/rest-api/students/auth";
    private static String studentEndpoint = "http://localhost:8080/rest-api/students/";
    private final static String CLIMethodSeperator = "\n=============";

    private ResteasyClient resteasyClient;

    private String username = "";
    private String password = "";
    private static String token = null;

    public RESTConsumer() {
        this.resteasyClient = new ResteasyClientBuilder().build();
    }

    public RESTConsumer(String username, String password) {
        this.resteasyClient = new ResteasyClientBuilder().build();
        this.username = username;
        this.password = password;
    }

    public void endSession() {
        if(!resteasyClient.isClosed())
            resteasyClient.close();
    }

    public void authorize() {
        ResteasyWebTarget target = resteasyClient.target(authorizationEndpoint);
        Form form = new Form();
        form.param("username", username);
        form.param("password", password);
        Response response = target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        token = response.readEntity(String.class);
        resteasyClient.register((ClientRequestFilter) clientRequestContext ->
                clientRequestContext.getHeaders().add("Authorization", "Bearer " + token));
    }

    private List<Student> getAllStudents(MultivaluedMap<String, Object> parameters) {
        List<Student> result = null;

        System.out.println(CLIMethodSeperator);
        System.out.print("GETTING STUDENTS LIST");

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "getAll");
        if(parameters != null && !parameters.isEmpty()) {
            target = target.queryParams(parameters);
            System.out.println(" WITH PARAMETERS: ");
            for(String key : parameters.keySet()) {
                System.out.println(" - " + key + ": " + parameters.getFirst(key));
            }
        }
        else {
            System.out.println(':');
        }
        Response response = target.request().get();
        int responseStatus = response.getStatus();
        if(responseStatus == 200) {
            result = response.readEntity(new GenericType<List<Student>>() {});
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    private Student getStudent(int idx) {
        Student result = null;

        System.out.println(CLIMethodSeperator);
        System.out.println("GETTING STUDENT " + idx + ':');

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "get/" + idx);
        Response response = target.request().get();
        int responseStatus = response.getStatus();

        if (responseStatus == 200)
            result = response.readEntity(Student.class);
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    private String showStudentProto(int idx) {
        System.out.println(CLIMethodSeperator);
        System.out.println("SHOWING STUDENT-PROTO " + idx + ':');

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "get/proto/" + idx);

        InputStream response = target.request().
                header("accept", MediaType.APPLICATION_OCTET_STREAM).get(InputStream.class);

        try {
            StudentProto.Student student = StudentProto.Student.parseFrom(IOUtils.toByteArray(response));
            return student.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student addStudent(Student student) {
        Student result = null;

        System.out.println(CLIMethodSeperator);
        System.out.println("ADDING STUDENT " + student.getIdx() + ':');

        if(token == null) {
            authorize();
        }

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "add");
        Response response = target.request().post(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        int responseStatus = response.getStatus();

        if(responseStatus == 200) {
            result = response.readEntity(Student.class);
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public String deleteStudent(int idx) {
        System.out.println(CLIMethodSeperator);
        System.out.println("DELETING STUDENT " + idx + ':');

        if(token == null) {
            authorize();
        }

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "delete/" + idx);
        Response response = target.request().delete();
        int responseStatus = response.getStatus();

        String result = response.readEntity(String.class);
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public Student editStudent(Student student) {
        Student result = null;

        System.out.println(CLIMethodSeperator);
        System.out.println("EDITING STUDENT " + student.getIdx() + ':');

        if(token == null) {
            authorize();
        }

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "edit");
        Response response = target.request().put(Entity.entity(student, MediaType.APPLICATION_JSON_TYPE));
        int responseStatus = response.getStatus();

        if(responseStatus == 200) {
            result = response.readEntity(Student.class);
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public byte[] getAvatar(int idx) {
        byte[] result = null;

        System.out.println(CLIMethodSeperator);
        System.out.println("GETTING STUDENT " + idx + " AVATAR:");

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "getAvatar/" + idx);
        Response response = target.request().get();
        int responseStatus = response.getStatus();

        if(responseStatus == 200) {
            String encodedAvatar = response.readEntity(String.class);
            result = Base64.getDecoder().decode(encodedAvatar);
        }
        response.close();

        System.out.println("RESPONSE STATUS: "+responseStatus);
        return result;
    }

    public void fillWithDummyData() {
        if(token == null) {
            authorize();
        }

        // Getting all students
        List<Student> allStudents = new ArrayList<>();
        ResteasyWebTarget getAllTarget = resteasyClient.target(studentEndpoint + "getAll");
        Response getAllResponse = getAllTarget.request().get();
        int responseStatus = getAllResponse.getStatus();
        if(responseStatus == 200) {
            allStudents = getAllResponse.readEntity(new GenericType<List<Student>>() {});
        }
        getAllResponse.close();
        for(Student studentToDelete : allStudents) {
            ResteasyWebTarget deleteAllTarget = resteasyClient.target(studentEndpoint + "delete/" + studentToDelete.getIdx());
            Response deleteResponse = deleteAllTarget.request().delete();
            deleteResponse.close();
        }

        ResteasyWebTarget target = resteasyClient.target(studentEndpoint + "add");
        List<Student> dummyList = StudentList.createSampleList();
        for(Student dummy : dummyList) {
            Response response = target.request().post(Entity.entity(dummy, MediaType.APPLICATION_JSON_TYPE));
            response.close();
        }
        System.out.println("FILLED WITH DUMMY DATA.");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        // Comment out below line for endpoints from Task 2
        //studentEndpoint += "zad3/";

        // Consumer initialization
        RESTConsumer consumer = new RESTConsumer("admin1","pasksword");

        // Fill database with dummy data
        consumer.fillWithDummyData();

        // Show all students
        List<Student> studentList = consumer.getAllStudents(null);
        if (studentList != null) {
            for(Student st : studentList) {
                System.out.println(st.toString());
            }
        }

        // Show students list with parameters (Faculty of EAIiIB and age of 22)
        MultivaluedMap<String, Object> parameters = new MultivaluedMapImpl<>();
        parameters.add("faculty","EAIiIB");
        parameters.add("age", 22);
        studentList = consumer.getAllStudents(parameters);
        if (studentList != null) {
            for (Student st : studentList) {
                System.out.println(st.toString());
            }
        }

        // Show one student
        Student student = consumer.getStudent(297270);
        if(student != null) {
            System.out.println(student.toString());

            // Show StudentProto
            String studentProto = consumer.showStudentProto(297270);
            System.out.println(studentProto);
        }

        // Get Student Base64 Avatar
        byte[] avatar = consumer.getAvatar(297270);
        if(avatar != null)
            System.out.println("Avatar byte array size: " + avatar.length);

        // Edit student
        if(student != null) {
            student.setFirstName("WcaleNieOskar");
            System.out.println(consumer.editStudent(student));
        }

        // Delete student
        System.out.println(consumer.deleteStudent(297270));

        // Add new student
        Student nStudent = new Student("Maciej", "Maciejowski", 19, "WMS", 113113);
        nStudent.addCourse(new Course("Test Course", 123));
        System.out.println(consumer.addStudent(nStudent));

        // Show all students (to show the deletion of one student and the other student added)
        studentList = consumer.getAllStudents(null);
        if (studentList != null) {
            for (Student st : studentList) {
                System.out.println(st.toString());
            }
        }

        // Ending client session
        consumer.endSession();
    }
}
