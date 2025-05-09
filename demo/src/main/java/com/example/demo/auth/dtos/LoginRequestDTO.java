package com.example.demo.auth.dtos;

public record LoginRequestDTO (
        String username,
        String password
) {}