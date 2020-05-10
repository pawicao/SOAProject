package pl.edu.agh.soa.models;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StudentList {
    private List<Student> students;

    public StudentList() { }

    @PostConstruct
    public void init() {
        this.students = createSampleList();
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

    public List<Student> getStudentsByAge(int age) {
        List<Student> resultList = new ArrayList<>();
        for(Student student : students) {
            if(student.getAge() == (age))
                resultList.add(student);
        }
        return resultList;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> getStudentsByFaculty(String facultyName) {
        List<Student> resultList = new ArrayList<>();
        for(Student student : students) {
            if(student.getFaculty().equals(facultyName))
                resultList.add(student);
        }
        return resultList;
    }

    private List<Student> createSampleList () {
        List<Student> listOfStudents = new ArrayList<>();

        List<Course> computerScienceCourses = new ArrayList<>();
        computerScienceCourses.add(Course.createCourse("Inteligencja obliczeniowa w analizie danych cyfrowych",
                4));
        computerScienceCourses.add(Course.createCourse("Interfejsy multimodalne",4));
        computerScienceCourses.add(Course.createCourse("Praktyka",4));
        computerScienceCourses.add(Course.createCourse("Prawo autorskie i patentowe",1));
        computerScienceCourses.add(Course.createCourse("SOA w projektowaniu i implementacji oprogramowania",
                4));
        computerScienceCourses.add(Course.createCourse("Studio projektowe 1",3));
        computerScienceCourses.add(Course.createCourse("Teoria kompilacji i kompilatory",4));
        computerScienceCourses.add(Course.createCourse("Teoria obliczeń",4));
        computerScienceCourses.add(Course.createCourse("Wprowadzenie do technologii mobilnych",4));

        List<Course> electronicsCourses = new ArrayList<>();
        electronicsCourses.add(Course.createCourse("Aplikacje mikrokontrolerów",5));
        electronicsCourses.add(Course.createCourse("Elektronika w medycynie",3));
        electronicsCourses.add(Course.createCourse("Systemy elektroniczne pojazdów",5));
        electronicsCourses.add(Course.createCourse("Problemy termiczne w układach elektronicznych",
                2));

        listOfStudents.add(new Student("Oskar","Pawica",22,"EAIiIB",
                297270,computerScienceCourses));
        listOfStudents.add(new Student("Jan","Kowalski",22,"EAIiIB",
                226720,computerScienceCourses));
        listOfStudents.add(new Student("Andrzej","Kowalski",25,"EAIiIB",
                292730,computerScienceCourses));
        listOfStudents.add(new Student("Jan","Nowak",28,"EAIiIB",
                298560,computerScienceCourses));

        listOfStudents.add(new Student("Marian","Kowalski",21,"IEiT",
                414242,electronicsCourses));
        listOfStudents.add(new Student("Jaromir","Nowak",22,"IEiT",
                636468,electronicsCourses));
        listOfStudents.add(new Student("Krzysztof","Krawczyk",73,"IEiT",
                532434,electronicsCourses));
        listOfStudents.add(new Student("Piotr","Piotrowski",24,"IEiT",
                111222,electronicsCourses));

        return listOfStudents;
    }

}
