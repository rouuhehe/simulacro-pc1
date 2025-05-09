package com.example.demo.medico.infrastructure;

import com.example.demo.medico.domain.Especialidad;
import com.example.demo.medico.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query("SELECT COUNT(c) FROM Consulta c WHERE c.medico.colegiatura = :codigo AND c.fecha = :fecha")
    long countConsultasDelDia(@Param("codigo") String codigo, @Param("fecha") LocalDate fecha);

    @Query("SELECT m FROM Medico m WHERE m.especialidad = :especialidad AND m.estadoMedico = 'ACTIVO'")
    List<Medico> findMedicosActivosPorEspecialidad(@Param("especialidad") Especialidad especialidad);


}
