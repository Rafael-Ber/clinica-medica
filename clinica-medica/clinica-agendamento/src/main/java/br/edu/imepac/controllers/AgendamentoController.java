package br.edu.imepac.controllers;

import br.edu.imepac.models.Agendamento;
import br.edu.imepac.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @Autowired
    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> getAllAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.findAll();
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> getAgendamentoById(@PathVariable Long id) {
        Optional<Agendamento> agendamento = agendamentoService.findById(id);
        return agendamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Agendamento> createAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento createdAgendamento = agendamentoService.save(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAgendamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> updateAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        if (!agendamentoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        agendamento.setId(id); // Garante que o ID do agendamento está definido corretamente
        Agendamento updatedAgendamento = agendamentoService.save(agendamento);
        return ResponseEntity.ok(updatedAgendamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id) {
        if (!agendamentoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
