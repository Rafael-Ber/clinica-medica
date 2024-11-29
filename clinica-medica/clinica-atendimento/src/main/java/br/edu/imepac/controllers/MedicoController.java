package br.edu.imepac.controllers;

import br.edu.imepac.services.MedicoService;
import br.edu.imepac.dto.MedicoDto;
import br.edu.imepac.models.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<MedicoDto>> getAllMedicos() {
        List<MedicoDto> medicos = medicoService.findAll().stream()
                .map(medicoService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDto> getMedicoById(@PathVariable Long id) {
        return medicoService.findById(id)
                .map(medicoService::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MedicoDto> createMedico(@RequestBody MedicoDto medicoDto) {
        Medico medico = medicoService.convertToEntity(medicoDto);
        Medico savedMedico = medicoService.save(medico);
        MedicoDto savedMedicoDto = medicoService.convertToDto(savedMedico);
        return new ResponseEntity<>(savedMedicoDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDto> updateMedico(@PathVariable Long id, @RequestBody MedicoDto medicoDto) {
        if (!medicoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        medicoDto.setId(id);
        Medico medico = medicoService.convertToEntity(medicoDto);
        Medico updatedMedico = medicoService.save(medico);
        MedicoDto updatedMedicoDto = medicoService.convertToDto(updatedMedico);
        return ResponseEntity.ok(updatedMedicoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        if (!medicoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}