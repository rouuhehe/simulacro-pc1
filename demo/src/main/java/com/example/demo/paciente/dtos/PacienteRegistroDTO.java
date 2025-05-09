package com.example.demo.paciente.dtos;

import com.example.demo.paciente.domain.TipoSangre;

import java.time.LocalDate;

public record PacienteRegistroDTO(
        String numeroHistoriaClinica,
        String nombres,
        String apellidos,
        LocalDate fechaNacimiento,
        String sexo,
        TipoSangre tipoSangre,
        String correoElectronico
) {}