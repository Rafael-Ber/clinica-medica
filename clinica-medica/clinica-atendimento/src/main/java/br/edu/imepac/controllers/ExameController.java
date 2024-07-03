package br.edu.imepac.controllers;

import br.edu.imepac.dto.ExameDto;
import br.edu.imepac.models.Exame;
import br.edu.imepac.services.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exames")
public class ExameController {

    private final ExameService exameService;

    @Autowired
    public ExameController(ExameService exameService) {
        this.exameService = exameService;
    }

    @GetMapping
    public ResponseEntity<List<ExameDto>> getAllExames() {
        List<ExameDto> exames = exameService.findAll().stream()
                .map(exameService::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(exames);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameDto> getExameById(@PathVariable Long id) {
        return exameService.findById(id)
                .map(exameService::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ExameDto> createExame(@RequestBody ExameDto exameDto) {
        Exame exame = exameService.convertToEntity(exameDto);
        Exame savedExame = exameService.save(exame);
        ExameDto savedExameDto = exameService.convertToDto(savedExame);
        return new ResponseEntity<>(savedExameDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExameDto> updateExame(@PathVariable Long id, @RequestBody ExameDto exameDto) {
        if (!exameService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        exameDto.setId(id);
        Exame exame = exameService.convertToEntity(exameDto);
        Exame updatedExame = exameService.save(exame);
        ExameDto updatedExameDto = exameService.convertToDto(updatedExame);
        return ResponseEntity.ok(updatedExameDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExame(@PathVariable Long id) {
        if (!exameService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        exameService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}