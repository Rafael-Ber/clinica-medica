package br.edu.imepac.controllers;

import br.edu.imepac.models.HorarioAtendimento;
import br.edu.imepac.services.HorarioAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios-atendimento")
public class HorarioAtendimentoController {

    private final HorarioAtendimentoService horarioAtendimentoService;

    @Autowired
    public HorarioAtendimentoController(HorarioAtendimentoService horarioAtendimentoService) {
        this.horarioAtendimentoService = horarioAtendimentoService;
    }

    @GetMapping
    public ResponseEntity<List<HorarioAtendimento>> getAllHorariosAtendimento() {
        List<HorarioAtendimento> horariosAtendimento = horarioAtendimentoService.findAll();
        return ResponseEntity.ok(horariosAtendimento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioAtendimento> getHorarioAtendimentoById(@PathVariable Long id) {
        Optional<HorarioAtendimento> horarioAtendimento = horarioAtendimentoService.findById(id);
        return horarioAtendimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HorarioAtendimento> createHorarioAtendimento(@RequestBody HorarioAtendimento horarioAtendimento) {
        HorarioAtendimento createdHorarioAtendimento = horarioAtendimentoService.save(horarioAtendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHorarioAtendimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioAtendimento> updateHorarioAtendimento(@PathVariable Long id, @RequestBody HorarioAtendimento horarioAtendimento) {
        if (!horarioAtendimentoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        horarioAtendimento.setId(id);
        HorarioAtendimento updatedHorarioAtendimento = horarioAtendimentoService.save(horarioAtendimento);
        return ResponseEntity.ok(updatedHorarioAtendimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorarioAtendimento(@PathVariable Long id) {
        if (!horarioAtendimentoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        horarioAtendimentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
