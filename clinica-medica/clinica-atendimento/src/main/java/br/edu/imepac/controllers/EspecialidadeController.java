package br.edu.imepac.controllers;

import br.edu.imepac.dto.EspecialidadeDto;
import br.edu.imepac.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @PostMapping
    public ResponseEntity<EspecialidadeDto> createEspecialidade(@RequestBody EspecialidadeDto especialidadeDto) {
        return ResponseEntity.ok(especialidadeService.createEspecialidade(especialidadeDto));
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeDto>> getAllEspecialidades() {
        return ResponseEntity.ok(especialidadeService.getAllEspecialidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeDto> getEspecialidadeById(@PathVariable Long id) {
        return ResponseEntity.ok(especialidadeService.getEspecialidadeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeDto> updateEspecialidade(@PathVariable Long id, @RequestBody EspecialidadeDto especialidadeDto) {
        return ResponseEntity.ok(especialidadeService.updateEspecialidade(id, especialidadeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidade(@PathVariable Long id) {
        especialidadeService.deleteEspecialidade(id);
        return ResponseEntity.noContent().build();
    }
}
