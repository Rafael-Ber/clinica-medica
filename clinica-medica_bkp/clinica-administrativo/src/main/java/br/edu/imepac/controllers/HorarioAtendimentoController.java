package br.edu.imepac.controllers;

import br.edu.imepac.models.HorarioAtendimento;
import br.edu.imepac.services.HorarioAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios-atendimento")
public class HorarioAtendimentoController {

    @Autowired
    private HorarioAtendimentoService horarioAtendimentoService;

    @GetMapping // Rota para listar todos os horários de atendimento
    public ResponseEntity<List<HorarioAtendimento>> listarHorariosAtendimento() {
        List<HorarioAtendimento> horarios = horarioAtendimentoService.findAll();
        return ResponseEntity.ok().body(horarios);
    }

    @GetMapping("/{id}") // Rota para buscar um horário de atendimento pelo ID
    public ResponseEntity<HorarioAtendimento> buscarPorId(@PathVariable Long id) {
        return horarioAtendimentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Rota para criar um novo horário de atendimento
    public ResponseEntity<HorarioAtendimento> criarHorarioAtendimento(@RequestBody HorarioAtendimento horarioAtendimento) {
        HorarioAtendimento novoHorario = horarioAtendimentoService.save(horarioAtendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHorario);
    }

    @PutMapping("/{id}") // Rota para atualizar um horário de atendimento pelo ID
    public ResponseEntity<HorarioAtendimento> atualizarHorarioAtendimento(@PathVariable Long id, @RequestBody HorarioAtendimento horarioAtendimento) {
        if (!horarioAtendimentoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        horarioAtendimento.setId(id);
        HorarioAtendimento horarioAtualizado = horarioAtendimentoService.save(horarioAtendimento);
        return ResponseEntity.ok(horarioAtualizado);
    }

    @DeleteMapping("/{id}") // Rota para deletar um horário de atendimento pelo ID
    public ResponseEntity<Void> deletarHorarioAtendimento(@PathVariable Long id) {
        horarioAtendimentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
