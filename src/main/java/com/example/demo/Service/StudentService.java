package com.example.demo.Service;

import com.example.demo.Model.Students;
import com.example.demo.Model.Subjects;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Students findByCode(String code) {
        return studentRepository.findByCode(code);
    }

    public Students findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}
