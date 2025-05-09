package com.example.demo.medico.domain;

import com.example.demo.medico.dtos.CrearMedicoRequest;
import com.example.demo.medico.dtos.MedicoDTO;
import com.example.demo.medico.exception.DoctorAlreadyExistsException;
import com.example.demo.medico.infrastructure.MedicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public MedicoDTO registrarMedico(CrearMedicoRequest request) {
        if (medicoRepository.existsById(request.getColegiatura())) {
            throw new DoctorAlreadyExistsException("Código ya registrado.");
        }

        Medico medico = new Medico();
        medico.setColegiatura(request.getColegiatura());
        medico.setNombre(request.getNombre());
        medico.setApellido(request.getApellido());
        medico.setEspecialidad(Especialidad.valueOf(String.valueOf(request.getEspecialidad())));
        medico.setEstadoMedico(EstadoMedico.ACTIVO);
        medico.setEmail(request.getEmail());

        medico = medicoRepository.save(medico);

        return toDTO(medico);
    }

    private MedicoDTO toDTO(Medico medico) {
        MedicoDTO dto = new MedicoDTO();
        dto.setColegiatura(medico.getColegiatura());
        dto.setNombre(medico.getNombre());
        dto.setApellido(medico.getApellido());
        dto.setEspecialidad(Especialidad.valueOf(medico.getEspecialidad().name()));
        dto.setEstadoMedico(EstadoMedico.valueOf(medico.getEstadoMedico().name()));
        dto.setEmail(medico.getEmail());
        return dto;
    }

    public List<MedicoDTO> obtenerDisponiblesPorEspecialidad(String especialidadStr) {
        Especialidad especialidad;
        try {
            especialidad = Especialidad.valueOf(especialidadStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Especialidad no válida: " + especialidadStr);
        }

        List<Medico> medicos = medicoRepository.findMedicosActivosPorEspecialidad(especialidad);

        LocalDate hoy = LocalDate.now();

        return medicos.stream()
                .filter(medico -> medicoRepository.countConsultasDelDia(String.valueOf(medico.getColegiatura()), hoy) < 15)
                .map(this::toDTO)
                .toList();
    }


}