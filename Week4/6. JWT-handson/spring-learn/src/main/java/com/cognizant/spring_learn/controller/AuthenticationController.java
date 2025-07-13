package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.AuthResponse;
import com.cognizant.spring_learn.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public AuthResponse authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String[] tokens = decodeBasicAuth(authHeader);
        String username = tokens[0];
        String password = tokens[1];

        // Basic user validation (hardcoded for now)
        if ("user".equals(username) && "pwd".equals(password)) {
            String jwt = JwtUtil.generateToken(username);
            return new AuthResponse(jwt);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    private String[] decodeBasicAuth(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header.");
        }
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
        return credentials.split(":", 2);
    }
}
