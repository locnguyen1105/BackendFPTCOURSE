package com.example.demo.Controller;

import com.example.demo.Model.Classes;
import com.example.demo.Model.Students;
import com.example.demo.Repository.ClassesRepository;
import com.example.demo.Service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ClassController {
    ClassesService classesService;

    @Autowired
    public ClassController(ClassesService classesService) {
        this.classesService = classesService;
    }


    @PostMapping("/class/{code}")
    @PreAuthorize("hasRole('STUDENT')")
    public List<Classes> getListClass(@PathVariable String code) {
        return classesService.getAll(code);
    }
}
