package com.example.demo.Controller;

import com.example.demo.Model.Students;
import com.example.demo.Model.Subjects;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/get/{code}")
    @PreAuthorize("hasRole('STUDENT')")
    public Students getStudent(@PathVariable String code) {
        return studentService.findByCode(code);
    }

}
