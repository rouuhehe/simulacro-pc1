package com.example.demo.consulta.dtos;

import java.time.LocalDateTime;

public record ConsultaRespuestaDTO(
        Long id,
        LocalDateTime fechaHora,
        String motivo,
        String paciente,
        String medico
) {}