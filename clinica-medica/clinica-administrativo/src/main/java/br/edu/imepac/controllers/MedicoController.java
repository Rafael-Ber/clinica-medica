package br.edu.imepac.controllers;

import br.edu.imepac.dto.MedicoDto;
import br.edu.imepac.models.Medico;
import br.edu.imepac.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping // Rota para listar todos os médicos
    public ResponseEntity<List<MedicoDto>> listarMedicos() {
        List<MedicoDto> medicos = medicoService.findAllDtos();
        return ResponseEntity.ok().body(medicos);
    }

    @GetMapping("/{id}") // Rota para buscar um médico pelo ID
    public ResponseEntity<MedicoDto> buscarPorId(@PathVariable Long id) {
        return medicoService.findById(id)
                .map(medico -> ResponseEntity.ok().body(medicoService.convertToDto(medico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Rota para cadastrar um novo médico
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody MedicoDto medicoDto) {
        Medico medico = medicoService.convertToEntity(medicoDto);
        Medico novoMedico = medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);
    }

    @PutMapping("/{id}") // Rota para atualizar um médico pelo ID
    public ResponseEntity<Medico> atualizarMedico(@PathVariable Long id, @RequestBody MedicoDto medicoDto) {
        if (!medicoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Medico medico = medicoService.convertToEntity(medicoDto);
        medico.setId(id);
        Medico medicoAtualizado = medicoService.save(medico);
        return ResponseEntity.ok(medicoAtualizado);
    }

    @DeleteMapping("/{id}") // Rota para excluir um médico pelo ID
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
