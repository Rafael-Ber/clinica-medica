package br.edu.imepac.controllers;

import br.edu.imepac.models.Sala;
import br.edu.imepac.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping
    public List<Sala> getAllSalas() {
        return salaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable Long id) {
        Optional<Sala> sala = salaRepository.findById(id);
        return sala.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sala createSala(@RequestBody Sala sala) {
        return salaRepository.save(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable Long id, @RequestBody Sala salaDetails) {
        Optional<Sala> sala = salaRepository.findById(id);
        if (sala.isPresent()) {
            Sala updatedSala = sala.get();
            updatedSala.setNumero(salaDetails.getNumero());
            updatedSala.setDescricao(salaDetails.getDescricao());
            updatedSala.setCapacidade(salaDetails.getCapacidade());
            return ResponseEntity.ok(salaRepository.save(updatedSala));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        Optional<Sala> sala = salaRepository.findById(id);
        if (sala.isPresent()) {
            salaRepository.delete(sala.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}