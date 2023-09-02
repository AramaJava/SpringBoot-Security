package net.java.springbootsecurity.controller;

import net.java.springbootsecurity.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AramaJava 02.09.2023
 */

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> students() {

        Student student1 = new Student();
        Student student2 = new Student();

        student1.setId(1L);
        student1.setFirstName("Aram");
        student1.setLastName("Abramyan");

        student2.setId(2L);
        student2.setFirstName("Viktor");
        student2.setLastName("Yacenko");

        students.add(student1);
        students.add(student2);

        return students;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public Student creaateStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
