package com.example.demo.Service;

import com.example.demo.Model.Subjects;
import com.example.demo.Repository.DashBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashBoardService {
    DashBoardRepository dashBoardRepository;

    @Autowired
    public DashBoardService(DashBoardRepository dashBoardRepository) {
        this.dashBoardRepository = dashBoardRepository;
    }

    public List<Subjects> findSubjectByStudent(String code) {
        return dashBoardRepository.findSubjectByStudent(code);
    }

}
