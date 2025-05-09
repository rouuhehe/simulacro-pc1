package com.example.demo.auth.dtos;

import com.example.demo.auth.model.Rol;

public record UsuarioDetalleDTO (
    String username,
    Rol rol
) {}
