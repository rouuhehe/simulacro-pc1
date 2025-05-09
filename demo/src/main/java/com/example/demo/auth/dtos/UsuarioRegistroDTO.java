package com.example.demo.auth.dtos;

import com.example.demo.auth.model.Rol;

public record UsuarioRegistroDTO (
    String username,
    String nombreCompleto,
    String password,
    Rol rol
) {}