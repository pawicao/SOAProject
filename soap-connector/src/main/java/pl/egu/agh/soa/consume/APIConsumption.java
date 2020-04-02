package pl.egu.agh.soa.consume;

import pl.egu.agh.soa.GetAllStudentsResponse;
import pl.egu.agh.soa.StudentService;
import pl.egu.agh.soa.StudentServiceService;

import javax.xml.ws.BindingProvider;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

public class APIConsumption {
    private static StudentServiceService studentService = new StudentServiceService();

    // APIConsumption class has been built but I highly recommend testing the Web Service with SoapUI
    public static void consume() {
        StudentService studentServicePort = studentService.getStudentServicePort();
        Map<String, Object> reqContext = ((BindingProvider)
                studentServicePort).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, "admin1");
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, "password");

        GetAllStudentsResponse.Students students = studentServicePort.getAllStudents();
        String encodedAvatar = studentServicePort.getBase64Avatar(297270);
        studentServicePort.addStudent(1,"Jan", "Kowalski",
                24,"EAIiIB");


        try (FileOutputStream fos = new FileOutputStream("/decodedImage.jpg")) {
            byte[] imageByteArray = Base64.getDecoder().decode(encodedAvatar);
            fos.write(imageByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
