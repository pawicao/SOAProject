package pl.edu.agh.soa.models;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students = new ArrayList<>();

    public static StudentList createSampleList() {
        StudentList sampleList = new StudentList();
        //TODO: Fill with data
        return sampleList;
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public boolean deleteStudent(int idx) {
        return students.removeIf(student -> student.getIdx() == idx);
    }

    public Student getStudentByIdx(int idx) {
        for(Student student : students) {
            if(student.getIdx() == idx)
                return student;
        }
        return null;
    }

    public List<Student> getStudentsByLastName(String lastName) {
        List<Student> resultList = new ArrayList<>();
        for(Student student : students) {
            if(student.getLastName().equals(lastName))
                resultList.add(student);
        }
        return resultList;
    }

    public List<Student> getStudentsByFirstName(String firstName) {
        List<Student> resultList = new ArrayList<>();
        for(Student student : students) {
            if(student.getFirstName().equals(firstName))
                resultList.add(student);
        }
        return resultList;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Course> getStudentsCourses(Student student) {
        return student.getCourses();
    }

    public List<Student> getStudentsByFaculty(String facultyName) {
        List<Student> resultList = new ArrayList<>();
        for(Student student : students) {
            if(student.getFaculty().equals(facultyName))
                resultList.add(student);
        }
        return resultList;
    }
}
