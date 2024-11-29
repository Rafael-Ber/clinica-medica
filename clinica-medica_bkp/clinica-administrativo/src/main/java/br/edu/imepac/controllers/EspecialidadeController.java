package br.edu.imepac.controllers;

import br.edu.imepac.models.Especialidade;
import br.edu.imepac.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades") // Endpoint base para as especialidades
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping // Rota para listar todas as especialidades
    public ResponseEntity<List<Especialidade>> listarEspecialidades() {
        List<Especialidade> especialidades = especialidadeService.findAll();
        return ResponseEntity.ok().body(especialidades);
    }

    @GetMapping("/{id}") // Rota para buscar uma especialidade pelo ID
    public ResponseEntity<Especialidade> buscarPorId(@PathVariable Long id) {
        return especialidadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Rota para criar uma nova especialidade
    public ResponseEntity<Especialidade> criarEspecialidade(@RequestBody Especialidade especialidade) {
        Especialidade novaEspecialidade = especialidadeService.save(especialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEspecialidade);
    }

    @PutMapping("/{id}") // Rota para atualizar uma especialidade pelo ID
    public ResponseEntity<Especialidade> atualizarEspecialidade(@PathVariable Long id, @RequestBody Especialidade especialidade) {
        if (!especialidadeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        especialidade.setId(id);
        Especialidade especialidadeAtualizada = especialidadeService.save(especialidade);
        return ResponseEntity.ok(especialidadeAtualizada);
    }

    @DeleteMapping("/{id}") // Rota para deletar uma especialidade pelo ID
    public ResponseEntity<Void> deletarEspecialidade(@PathVariable Long id) {
        especialidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
