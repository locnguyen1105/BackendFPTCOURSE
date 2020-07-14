package com.example.demo.Service;

import com.example.demo.Model.Subjects;
import com.example.demo.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    public Subjects findByCode(String code) {
        return subjectRepository.findAll(code);
    }

    public List<Subjects> findSubjectByStudent(String code) {
        return subjectRepository.findSubjectByStudent(code);
    }
}
