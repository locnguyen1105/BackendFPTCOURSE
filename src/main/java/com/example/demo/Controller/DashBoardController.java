package com.example.demo.Controller;

import com.example.demo.Model.Subjects;
import com.example.demo.Service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashBoardController {
    DashBoardService dashBoardService;

    @Autowired
    public DashBoardController(DashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }


}
