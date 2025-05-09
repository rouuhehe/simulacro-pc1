package com.example.demo.auth.controller;

import com.example.demo.auth.model.Usuario;
import com.example.demo.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registrar(@RequestBody Usuario usuario) {
        authService.registrar(usuario);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {
        String token = authService.login(body.get("username"), body.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserInfo(Authentication authentication) {
        // Obtén el usuario desde la autenticación
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autenticado");
        }

        // Supongamos que el usuario tiene un nombre de usuario en su autenticación
        String username = authentication.getName();
        return ResponseEntity.ok("Usuario autenticado: " + username);
    }
}