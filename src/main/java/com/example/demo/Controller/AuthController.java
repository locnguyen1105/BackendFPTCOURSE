package com.example.demo.Controller;

import com.example.demo.Exception.ApiRequestException;
import com.example.demo.Model.Students;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Response.JwtResponse;
import com.example.demo.Service.StudentService;
import com.example.demo.security.Auth.JwtUtils;
import com.example.demo.security.Service.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;

    StudentService studentService;

    @Autowired
    public AuthController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        StudentDetails studentDetails = (StudentDetails) authentication.getPrincipal();
        List<String> roles = studentDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, "Bearer", roles, studentService.findByUsername(loginRequest.getUsername())));
    }
}
