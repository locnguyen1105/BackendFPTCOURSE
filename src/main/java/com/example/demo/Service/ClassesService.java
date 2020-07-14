package com.example.demo.Service;

import com.example.demo.Model.Classes;
import com.example.demo.Repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    ClassesRepository classesRepository;

    @Autowired
    public ClassesService(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    public List<Classes> getAll(String code) {
        return classesRepository.findByCode(code);
    }
}
