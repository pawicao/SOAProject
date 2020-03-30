package pl.edu.agh.soa.models;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        return students.add(student);
    }
    public Student getStudentByIdx(int idx);
    public List<Student> getStudentsByLastName(String lastName);
    public List<Student> getAllStudents() {
        return students;
    }
}
