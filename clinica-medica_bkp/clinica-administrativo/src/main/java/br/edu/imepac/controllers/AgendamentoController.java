package br.edu.imepac.controllers;

import br.edu.imepac.models.Agendamento;
import br.edu.imepac.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos") // Endpoint base para os agendamentos
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping // Rota para listar todos os agendamentos
    public ResponseEntity<List<Agendamento>> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.findAll();
        return ResponseEntity.ok().body(agendamentos);
    }

    @GetMapping("/{id}") // Rota para buscar um agendamento pelo ID
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable Long id) {
        return agendamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Rota para criar um novo agendamento
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.save(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    @PutMapping("/{id}") // Rota para atualizar um agendamento existente pelo ID
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        if (!agendamentoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agendamento.setId(id);
        Agendamento agendamentoAtualizado = agendamentoService.save(agendamento);
        return ResponseEntity.ok(agendamentoAtualizado);
    }

    @DeleteMapping("/{id}") // Rota para deletar um agendamento pelo ID
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
