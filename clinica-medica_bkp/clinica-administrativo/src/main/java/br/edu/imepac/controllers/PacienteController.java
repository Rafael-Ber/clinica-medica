package br.edu.imepac.controllers;

import br.edu.imepac.models.Paciente;
import br.edu.imepac.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping // Rota para listar todos os pacientes
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        return ResponseEntity.ok().body(pacientes);
    }

    @GetMapping("/{id}") // Rota para buscar um paciente pelo ID
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return pacienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Rota para cadastrar um novo paciente
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    @PutMapping("/{id}") // Rota para atualizar um paciente pelo ID
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        if (!pacienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paciente.setId(id);
        Paciente pacienteAtualizado = pacienteService.save(paciente);
        return ResponseEntity.ok(pacienteAtualizado);
    }

    @DeleteMapping("/{id}") // Rota para excluir um paciente pelo ID
    public ResponseEntity<Void> excluirPaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
