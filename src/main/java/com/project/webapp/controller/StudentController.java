package com.project.webapp.controller;

import com.project.webapp.dao.StudentRepo;
import com.project.webapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepo repo;

    @GetMapping("home")
    public String home(){
        System.out.println("Hello");
        return "Hello";
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        repo.save(student);
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @GetMapping("student")
    public Optional<Student> getStudent(@RequestParam("id") int id) {
        return repo.findById(id);
    }

    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        Student s = repo.getReferenceById(id);
        repo.delete(s);
        return "Deleted";
    }

    @PutMapping("student")
    public Student createOrUpdateStudent(@RequestBody Student student) {
        repo.save(student);
        return student;
    }
}
