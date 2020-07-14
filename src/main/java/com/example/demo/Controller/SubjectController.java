package com.example.demo.Controller;

import com.example.demo.Model.Subjects;
import com.example.demo.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SubjectController {
    SubjectService subjectService;

    @Autowired

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subject/{code}")
    public Subjects findByCode(@PathVariable String code) {
        return subjectService.findByCode(code);
    }

    @PostMapping("/dashboard/subject/{code}")
    @PreAuthorize("hasRole('STUDENT')")
    public List<Subjects> findSubjectByStudent(@PathVariable String code) {
        return subjectService.findSubjectByStudent(code);
    }
}
