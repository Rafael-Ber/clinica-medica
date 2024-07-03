package br.edu.imepac.controllers;

import br.edu.imepac.models.StatusAgendamento;
import br.edu.imepac.services.StatusAgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/status-agendamento")
public class StatusAgendamentoController {

    private final StatusAgendamentoService statusAgendamentoService;

    @Autowired
    public StatusAgendamentoController(StatusAgendamentoService statusAgendamentoService) {
        this.statusAgendamentoService = statusAgendamentoService;
    }

    @GetMapping
    public ResponseEntity<List<StatusAgendamento>> listarStatusAgendamento() {
        List<StatusAgendamento> statusAgendamentos = statusAgendamentoService.listarTodos();
        return ResponseEntity.ok(statusAgendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusAgendamento> buscarStatusAgendamentoPorId(@PathVariable Long id) {
        StatusAgendamento statusAgendamento = statusAgendamentoService.buscarPorId(id);
        return ResponseEntity.ok(statusAgendamento);
    }

    @PostMapping
    public ResponseEntity<StatusAgendamento> criarStatusAgendamento(@RequestBody StatusAgendamento statusAgendamento) {
        StatusAgendamento novoStatusAgendamento = statusAgendamentoService.salvar(statusAgendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoStatusAgendamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarStatusAgendamento(@PathVariable Long id) {
        statusAgendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
