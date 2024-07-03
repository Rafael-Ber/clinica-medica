package br.edu.imepac.controllers;

import br.edu.imepac.services.PacienteService;
import br.edu.imepac.dto.PacienteDto;
import br.edu.imepac.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> getAllPacientes() {
        List<PacienteDto> pacientes = pacienteService.findAll().stream()
                .map(pacienteService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> getPacienteById(@PathVariable Long id) {
        return pacienteService.findById(id)
                .map(paciente -> ResponseEntity.ok(pacienteService.convertToDto(paciente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PacienteDto> createPaciente(@RequestBody PacienteDto pacienteDto) {
        Paciente paciente = pacienteService.convertToEntity(pacienteDto);
        Paciente savedPaciente = pacienteService.save(paciente);
        PacienteDto savedPacienteDto = pacienteService.convertToDto(savedPaciente);
        return new ResponseEntity<>(savedPacienteDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> updatePaciente(@PathVariable Long id, @RequestBody PacienteDto pacienteDto) {
        if (!pacienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pacienteDto.setId(id);
        Paciente paciente = pacienteService.convertToEntity(pacienteDto);
        Paciente updatedPaciente = pacienteService.save(paciente);
        PacienteDto updatedPacienteDto = pacienteService.convertToDto(updatedPaciente);
        return ResponseEntity.ok(updatedPacienteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        if (!pacienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pacienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}