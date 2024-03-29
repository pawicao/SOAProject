package pl.edu.agh.soa.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.edu.agh.soa.daos.StudentDao;
import pl.edu.agh.soa.entities.StudentEntity;
import pl.edu.agh.soa.auth.RequiresAuthentication;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.models.StudentList;
import pl.edu.agh.soa.models.StudentProto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Path("/")
@Api( value = "Student Controller")
public class StudentController {

    @Inject
    private StudentList students;

    @Inject
    private StudentDao studentDao;

    //
    // Zadanie 3: Metody DAO
    //

    @GET
    @Path("/zad3/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "[JPA] Returns a student with given index number",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No student with given index number found"),
            @ApiResponse(code = 500, message = "Student record broken"),
            @ApiResponse(code = 200, message = "Student found", response = Student.class)
    })
    public Response daoGetStudentByIdx(@PathParam("id") int idx) {
        try {
            Student result = studentDao.findById(idx);
            return Response.status(Response.Status.OK).entity(result).build();
        }
        catch (javassist.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error: student not found.").build();
        }
    }

    @GET
    @Path("/zad3/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "[JPA] Returns a list of students with given parameters",
            notes = "If no parameters passed, returns all students from DB.",
            response = StudentEntity.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No students with given parameters found"),
            @ApiResponse(code = 200, message = "Students found",
                    response = StudentEntity.class,
                    responseContainer = "List"
            )
    })
    public Response daoGetAllStudents(
            @Context UriInfo ui
    ) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        Map<String, String> params = new HashMap<>();
        for(String str : queryParams.keySet()){
            params.put(str, queryParams.getFirst(str));
        }
        List<Student> resultList = studentDao.findAll(params);
        if(resultList == null || resultList.size() == 0)
            return Response.status(Response.Status.NOT_FOUND).entity("No students with given parameters found").build();
        return Response.status(Response.Status.OK).entity(resultList).build();
    }


    @POST
    @Path("/zad3/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RequiresAuthentication
    @ApiOperation(
            value = "[JPA] Adds and returns a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 409, message = "Student already exists in the DB"),
            @ApiResponse(code = 200, message = "Student added successfully. Returns added student.",
                    response = Student.class)
    })
    public Response daoAddStudent(Student student) {
        try {
            studentDao.create(student);
            return Response.status(Response.Status.OK).entity(student).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).
                    entity("Error - this student already exists in the DB").build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/zad3/delete/{id}")
    @RequiresAuthentication
    @ApiOperation(
            value = "[JPA] Deletes a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 200, message = "Student deleted successfully.")
    })
    public Response daoDeleteStudent(@PathParam("id") int idx) {
        try {
            studentDao.remove(idx);
            String entity = "Student " + idx + " deleted successfully.";
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        catch (javassist.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error: student not found.").build();
        }
    }

    @PUT
    @Path("/zad3/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RequiresAuthentication
    @ApiOperation(
            value = "[JPA] Edits and returns a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 200, message = "Student edited successfully. Returns edited student.",
                    response = Student.class)
    })
    public Response daoEditStudent(Student student) {
        try {
            studentDao.update(student);
            return Response.status(Response.Status.OK).entity(student).build();
        } catch(IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Student doesn't exist in the DB.").build();
        }
    }

    @GET
    @Path("/zad3/getAvatar/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(
            value = "[JPA] Gets base64 encoded avatar of the student.",
            response = byte.class,
            responseContainer = "Array"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 500, message = "A server error has occured while retrieving encoded avatar."),
            @ApiResponse(code = 200, message = "Returns student's encoded avatar.")
    })
    public Response daoGetBase64Avatar(@PathParam("id") int idx) {
        try {
            Student result = studentDao.findById(idx);

            String encodedFile = null;

            URL resource = getClass().getClassLoader().getResource(result.getAvatarFilePath());
            InputStream iStream = resource.openStream();
            int resourceSize = resource.openConnection().getContentLength();
            byte[] bytes = new byte[resourceSize];
            iStream.read(bytes);
            encodedFile = Base64.getEncoder().encodeToString(bytes);

            return Response.status(Response.Status.OK).entity(encodedFile).build();
        }
        catch (javassist.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error: student not found.").build();
        }
        catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
        }
    }

    @GET
    @Path("/zad3/get/proto/{id}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @ApiOperation(
            value = "[JPA] Returns a student (protobuf) with given index number",
            response = byte.class,
            responseContainer = "Array"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 200, message = "Returns a student proto object")
    })
    public Response daoGetStudentProto(@PathParam("id") int idx) {
        try {
            Student result = studentDao.findById(idx);
            StudentProto.Student.Builder builder = StudentProto.Student.newBuilder();

            builder.setIdx(result.getIdx());
            if(result.getAge() != null) builder.setAge(result.getAge());
            builder.setFirstName(result.getFirstName());
            builder.setLastName(result.getLastName());
            if(result.getFaculty() != null) builder.setFaculty(result.getFaculty());
            for(Course course : result.getCourses()) {
                StudentProto.Course.Builder courseBuilder = StudentProto.Course.newBuilder();
                courseBuilder.setEcts(course.getEcts());
                courseBuilder.setName(course.getName());
                builder.addCourses(courseBuilder);
            }
            return Response.ok(builder.build().toByteArray(), MediaType.APPLICATION_OCTET_STREAM).
                    status(Response.Status.OK).build();
        } catch (javassist.NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error: student not found.").build();
        }
    }

    //
    // Zadanie 2: Metody
    //

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns a list of students with given parameters",
            notes = "If no parameters passed, returns all students from DB.",
            response = Student.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No students with given parameters found"),
            @ApiResponse(code = 200, message = "Students found",
                    response = Student.class,
                    responseContainer = "List"
            )
    })
    public Response getAllStudents(
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName,
            @QueryParam("age") int age,
            @QueryParam("faculty") String faculty
    ) {

        List<Student> resultList = students.getAllStudents();

        if(firstName != null)
            resultList = resultList.stream().filter(student -> student.getFirstName().equals(firstName)).
                    collect(Collectors.toList());
        if(lastName != null)
            resultList = resultList.stream().filter(student -> student.getLastName().equals(lastName)).
                    collect(Collectors.toList());
        if(age != 0)
            resultList = resultList.stream().filter(student -> student.getAge() == age).
                    collect(Collectors.toList());
        if(faculty != null)
            resultList = resultList.stream().filter(student -> student.getFaculty().equals(faculty)).
                    collect(Collectors.toList());
        if(resultList == null || resultList.size() == 0)
            return Response.status(Response.Status.NOT_FOUND).entity("No students with given parameters found").build();
        return Response.status(Response.Status.OK).entity(resultList).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns a student with given index number",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No student with given index number found"),
            @ApiResponse(code = 200, message = "Student found", response = Student.class)
    })
    public Response getStudentByIdx(@PathParam("id") int idx) {
        Student result = students.getStudentByIdx(idx);
        if(result == null)
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Error - student with this idx doesn't exist in the DB").build();
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RequiresAuthentication
    @ApiOperation(
            value = "Adds and returns a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 409, message = "Student already exists in the DB"),
            @ApiResponse(code = 200, message = "Student added successfully. Returns added student.",
                    response = Student.class)
    })
    public Response addStudent(Student student) {
        if(students.getStudentByIdx(student.getIdx()) == null) {
            students.addStudent(student);
            return Response.status(Response.Status.OK).entity(student).build();
        }
        return Response.status(Response.Status.CONFLICT).
                entity("Error - this student already exists in the DB").build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    @RequiresAuthentication
    @ApiOperation(
            value = "Deletes a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 200, message = "Student deleted successfully.")
    })
    public Response deleteStudent(@PathParam("id") int idx) {
        boolean deletion = students.deleteStudent(idx);
        if(deletion) {
            String entity = "Student " + idx + " deleted successfully.";
            return Response.status(Response.Status.OK).entity(entity).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Student doesn't exist in the DB.").build();
    }

    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RequiresAuthentication
    @ApiOperation(
            value = "Edits and returns a student.",
            notes = "You must provide authentication token. See 'Authentication Controller' documentation",
            response = Student.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 200, message = "Student edited successfully. Returns edited student.",
                    response = Student.class)
    })
    public Response editStudent(Student student) {
        Student studentToEdit = students.getStudentByIdx(student.getIdx());
        if(studentToEdit == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Student doesn't exist in the DB.").build();
        }
        studentToEdit.setFirstName(student.getFirstName());
        studentToEdit.setLastName(student.getLastName());
        studentToEdit.setAge(student.getAge());
        studentToEdit.setFaculty(student.getFaculty());
        return Response.status(Response.Status.OK).entity(studentToEdit).build();
    }

    @GET
    @Path("/getAvatar/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(
            value = "Gets base64 encoded avatar of the student.",
            response = byte.class,
            responseContainer = "Array"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 500, message = "A server error has occured while retrieving encoded avatar."),
            @ApiResponse(code = 200, message = "Returns student's encoded avatar.")
    })
    public Response getBase64Avatar(@PathParam("id") int idx) {
        Student student = students.getStudentByIdx(idx);
        if(student ==  null)
            return Response.status(Response.Status.NOT_FOUND).entity("Student doesn't exist in the DB.").build();
        String encodedFile = null;

        URL resource = getClass().getClassLoader().getResource(student.getAvatarFilePath());
        InputStream iStream = null;
        try {
            iStream = resource.openStream();
            int resourceSize = resource.openConnection().getContentLength();
            byte[] bytes = new byte[resourceSize];
            iStream.read(bytes);
            encodedFile = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
        }
        return Response.status(Response.Status.OK).entity(encodedFile).build();
    }

    @GET
    @Path("/get/proto/{id}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @ApiOperation(
            value = "Returns a student (protobuf) with given index number",
            response = byte.class,
            responseContainer = "Array"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Student doesn't exist in the DB."),
            @ApiResponse(code = 200, message = "Returns a student proto object")
    })
    public Response getStudentProto(@PathParam("id") int idx) {
        Student result = students.getStudentByIdx(idx);
        if(result == null)
            return Response.status(Response.Status.NOT_FOUND).
                    entity("Error - student with this idx doesn't exist in the DB").build();

        StudentProto.Student.Builder builder = StudentProto.Student.newBuilder();

        builder.setIdx(result.getIdx());
        builder.setAge(result.getAge());
        builder.setFirstName(result.getFirstName());
        builder.setLastName(result.getLastName());
        builder.setFaculty(result.getFaculty());
        for(Course course : result.getCourses()) {
            StudentProto.Course.Builder courseBuilder = StudentProto.Course.newBuilder();
            courseBuilder.setEcts(course.getEcts());
            courseBuilder.setName(course.getName());
            builder.addCourses(courseBuilder);
        }

        return Response.ok(builder.build().toByteArray(), MediaType.APPLICATION_OCTET_STREAM).
                status(Response.Status.OK).build();
    }


}
