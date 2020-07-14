package com.example.demo.Response;

import com.example.demo.Model.Students;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private List<String> roles;
    private Students student;

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
}
