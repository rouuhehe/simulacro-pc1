package com.example.demo.paciente.domain;

import com.example.demo.consulta.domain.Consulta;
import com.example.demo.medico.domain.Medico;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroHistoriaClinica;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @Column(updatable = false)
    @Past
    private LocalDate fechaNacimiento;

    @Column(nullable = false, updatable = false)
    private TipoSangre tipoSangre;

    private EstadoPaciente estadoPaciente = EstadoPaciente.ACTIVO;

    @Email(message = "El email no es valido")
    private String email;

    @ManyToOne
    private Medico medicoCabecera;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consulta;
}
