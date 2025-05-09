package com.example.demo.consulta.domain;

import com.example.demo.medico.domain.EstadoMedico;
import com.example.demo.medico.domain.Medico;
import com.example.demo.paciente.domain.EstadoPaciente;
import com.example.demo.paciente.domain.Paciente;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;

    private String motivo;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;

    @PrePersist
    public void validadRestricciones(){
        if(paciente.getEstadoPaciente() == EstadoPaciente.FALLECIDO){
            throw new IllegalStateException("No se puede registrar una consulta a un muerto");
        }

        if (medico.getEstadoMedico() != EstadoMedico.ACTIVO){
            throw new IllegalStateException("El médico no está disponible");
        }

        // especialidad restriccion -> service
        // limite de 15 consultas per day -> service
        // conflico de horario -> service

    }

}
