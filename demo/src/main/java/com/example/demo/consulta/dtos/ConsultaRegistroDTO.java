package com.example.demo.consulta.dtos;

import java.time.LocalDateTime;

public record ConsultaRegistroDTO(
        LocalDateTime fechaHora,
        String motivo,
        String numeroHistoriaClinica,
        String codigoColegiatura
) {}