package dev.patika.graduationproject.utils;

import dev.patika.graduationproject.models.Course;
import dev.patika.graduationproject.models.PermanentInstructor;
import dev.patika.graduationproject.models.Student;
import dev.patika.graduationproject.models.VisitingResearcher;
import dev.patika.graduationproject.repositories.CourseRepository;
import dev.patika.graduationproject.repositories.InstructorRepository;
import dev.patika.graduationproject.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        courseRepository.deleteAll();
        instructorRepository.deleteAll();
        studentRepository.deleteAll();

        Course course1 = new Course();
        course1.setName("HISTORY");
        course1.setCode(101);
        course1.setCreditScore(10);

        Course course2 = new Course();
        course2.setName("ENGLISH");
        course2.setCode(553);
        course2.setCreditScore(8);

        Course course3 = new Course();
        course3.setName("BIOLOGY");
        course3.setCode(102);
        course3.setCreditScore(7);

        VisitingResearcher instructor1 = new VisitingResearcher();
        instructor1.setName("Batuhan Aydın");
        instructor1.setAddress("İzmir");
        instructor1.setHourlySalary(2900);
        instructor1.setPhoneNo("5531235656");

        PermanentInstructor instructor2 = new PermanentInstructor();
        instructor2.setName("Ali Temiz");
        instructor2.setAddress("İstanbul");
        instructor2.setFixedSalary(3000);
        instructor2.setPhoneNo("5447891212");

        PermanentInstructor instructor3 = new PermanentInstructor();
        instructor3.setName("Gamze Yılmaz");
        instructor3.setAddress("Ankara");
        instructor3.setFixedSalary(2500);
        instructor3.setPhoneNo("5357594623");

        Student student1 = new Student();
        student1.setName("Alperen Keskin");
        student1.setAddress("Kırşehir");
        student1.setBirthDate(LocalDate.of(1997,2,5));
        student1.setGender("Male");

        Student student2 = new Student();
        student2.setName("Cenk Ekşioğlu");
        student2.setAddress("Rize");
        student2.setBirthDate(LocalDate.of(1996,7,19));
        student2.setGender("Male");

        Student student3 = new Student();
        student3.setName("Naz Turgay");
        student3.setAddress("Aydın");
        student3.setBirthDate(LocalDate.of(2000,8,20));
        student3.setGender("Female");

        Student student4 = new Student();
        student4.setName("Banu Çalışkan");
        student4.setAddress("Manisa");
        student4.setBirthDate(LocalDate.of(1995,10,15));
        student4.setGender("Female");

        Student student5 = new Student();
        student5.setName("Pelin Doğru");
        student5.setAddress("Malatya");
        student5.setBirthDate(LocalDate.of(2001,11,3));
        student5.setGender("Female");

        Student student6 = new Student();
        student6.setName("Selin Sağlam");
        student6.setAddress("Denizli");
        student6.setBirthDate(LocalDate.of(2003,6,17));
        student6.setGender("Female");

        List<Course> courseList1 = new ArrayList<>();
        List<Course> courseList2 = new ArrayList<>();
        List<Course> courseList3 = new ArrayList<>();
        List<Course> courseList4 = new ArrayList<>();
        List<Course> courseList5 = new ArrayList<>();
        List<Course> courseList6 = new ArrayList<>();
        List<Course> courseList7 = new ArrayList<>();
        List<Course> courseList8 = new ArrayList<>();
        List<Course> courseList9 = new ArrayList<>();

        List<Student> studentList1 = new ArrayList<>();
        List<Student> studentList2 = new ArrayList<>();
        List<Student> studentList3 = new ArrayList<>();

        courseList1.add(course1);
        courseList2.add(course2);
        courseList3.add(course3);
        courseList4.add(course1);
        courseList5.add(course1);
        courseList6.add(course2);
        courseList7.add(course2);
        courseList8.add(course3);
        courseList9.add(course3);

        studentList1.add(student1);
        studentList1.add(student2);
        studentList2.add(student3);
        studentList2.add(student4);
        studentList3.add(student5);
        studentList3.add(student6);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);
        course1.setStudents(studentList1);
        course2.setStudents(studentList2);
        course3.setStudents(studentList3);
        instructor1.setCourses(courseList1);
        instructor2.setCourses(courseList2);
        instructor3.setCourses(courseList3);
        student1.setCourseList(courseList4);
        student2.setCourseList(courseList5);
        student3.setCourseList(courseList6);
        student4.setCourseList(courseList7);
        student5.setCourseList(courseList8);
        student6.setCourseList(courseList9);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);

        logger.info("All test data saved..");
    }
}

