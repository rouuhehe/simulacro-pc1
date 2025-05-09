package com.example.demo.medico.application;

import com.example.demo.medico.domain.MedicoService;
import com.example.demo.medico.dtos.CrearMedicoRequest;
import com.example.demo.medico.dtos.MedicoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@PreAuthorize("hasRole('ADMIN')")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> registrar(@Valid @RequestBody CrearMedicoRequest request) {
        return new ResponseEntity<>(medicoService.registrarMedico(request), HttpStatus.CREATED);
    }

    @GetMapping("/{especialidad}/disponibilidad")
    @PreAuthorize("hasAnyRole('ADMIN','RECEPCIONISTA','MEDICO')")
    public ResponseEntity<List<MedicoDTO>> disponibilidad(@PathVariable String especialidad) {
        return ResponseEntity.ok(medicoService.obtenerDisponiblesPorEspecialidad(especialidad));
    }
}
