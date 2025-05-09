package com.example.demo.medico.dtos;

import com.example.demo.medico.domain.Especialidad;
import com.example.demo.medico.domain.EstadoMedico;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MedicoDTO {
    private Long colegiatura;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private EstadoMedico estadoMedico;
    private String email;
}
