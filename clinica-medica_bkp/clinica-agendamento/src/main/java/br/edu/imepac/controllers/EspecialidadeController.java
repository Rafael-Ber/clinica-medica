package br.edu.imepac.controllers;

import br.edu.imepac.models.Especialidade;
import br.edu.imepac.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @Autowired
    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Especialidade>> getAllEspecialidades() {
        List<Especialidade> especialidades = especialidadeService.findAll();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> getEspecialidadeById(@PathVariable Long id) {
        Optional<Especialidade> especialidade = especialidadeService.findById(id);
        return especialidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Especialidade> createEspecialidade(@RequestBody Especialidade especialidade) {
        Especialidade createdEspecialidade = especialidadeService.save(especialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEspecialidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidade> updateEspecialidade(@PathVariable Long id, @RequestBody Especialidade especialidade) {
        if (!especialidadeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        especialidade.setId(id);
        Especialidade updatedEspecialidade = especialidadeService.save(especialidade);
        return ResponseEntity.ok(updatedEspecialidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidade(@PathVariable Long id) {
        if (!especialidadeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        especialidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
