package com.example.demo.medico.domain;

import com.example.demo.consulta.domain.Consulta;
import com.example.demo.paciente.domain.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.DefaultStyledDocument;
import java.util.List;

@Entity
@Getter
@Setter
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colegiatura;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidad especialidad = Especialidad.MEDICINA_GENERAL;

    @Enumerated(EnumType.STRING)
    private EstadoMedico estadoMedico = EstadoMedico.ACTIVO;

    @Email(message = "El email no es valido")
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "medicoCabecera")
    private List<Paciente> pacientes;

    @OneToMany
    private List<Consulta> consultas;
}
