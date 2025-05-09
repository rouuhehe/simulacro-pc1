package com.example.demo.medico.dtos;

import com.example.demo.medico.domain.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearMedicoRequest {
    @NotBlank
    private Long colegiatura;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotNull
    private Especialidad especialidad;
    @Email
    private String email;
}
