package br.edu.imepac.controllers;

import br.edu.imepac.dto.PrescricaoDto;
import br.edu.imepac.models.Prescricao;
import br.edu.imepac.services.PrescricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescricoes")
public class PrescricaoController {

    @Autowired
    private PrescricaoService prescricaoService;

    @GetMapping
    public ResponseEntity<List<PrescricaoDto>> getAllPrescricoes() {
        return ResponseEntity.ok(prescricaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescricaoDto> getPrescricaoById(@PathVariable Long id) {
        return prescricaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PrescricaoDto> createPrescricao(@RequestBody PrescricaoDto prescricaoDto) {
        Prescricao prescricao = prescricaoService.convertToEntity(prescricaoDto);
        PrescricaoDto createdPrescricao = prescricaoService.convertToDto(prescricaoService.save(prescricao));
        return ResponseEntity.ok(createdPrescricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescricaoDto> updatePrescricao(@PathVariable Long id, @RequestBody PrescricaoDto prescricaoDto) {
        if (!prescricaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Prescricao prescricao = prescricaoService.convertToEntity(prescricaoDto);
        prescricao.setId(id);
        PrescricaoDto updatedPrescricao = prescricaoService.convertToDto(prescricaoService.save(prescricao));
        return ResponseEntity.ok(updatedPrescricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescricao(@PathVariable Long id) {
        if (!prescricaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prescricaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
