package com.example.demo.paciente.dtos;

import com.example.demo.paciente.domain.EstadoPaciente;

public record PacienteResumenDTO (
   // get / pacientes
   String numeroHistoriaClinica,
   String nombres,
   String apellidos,
   EstadoPaciente estado
) {}
