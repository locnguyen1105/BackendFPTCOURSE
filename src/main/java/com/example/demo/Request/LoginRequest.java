package com.example.demo.Request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequest {
    @NotNull
    String username;
    @NotNull
    String password;
}
