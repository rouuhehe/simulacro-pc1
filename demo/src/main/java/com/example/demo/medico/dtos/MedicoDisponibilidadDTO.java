package com.example.demo.medico.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record MedicoDisponibilidadDTO(
        String codigoColegiatura,
        String nombres,
        String apellidos,
        List<LocalDateTime> horariosDisponibles
) {}
