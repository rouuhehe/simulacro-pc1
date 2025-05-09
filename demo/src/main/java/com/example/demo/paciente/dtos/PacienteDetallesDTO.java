package com.example.demo.paciente.dtos;

import com.example.demo.paciente.domain.EstadoPaciente;
import com.example.demo.paciente.domain.TipoSangre;

import java.time.LocalDate;
import java.util.List;

public record PacienteDetallesDTO (

    // GET / pacientes / historiaID jeje

        String numeroHistoriaClinica,
        String nombres,
        String apellidos,
        LocalDate fechaNacimiento,
        String sexo,
        TipoSangre tipoSangre,
        List<String> alergias,
        EstadoPaciente estado,
        String correoElectronico,
        String medicoCabecera // puede ser nombre completo o código

) {}
