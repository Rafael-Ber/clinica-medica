package br.edu.imepac.controllers;

import br.edu.imepac.models.Funcionario;
import br.edu.imepac.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            Funcionario updatedFuncionario = funcionario.get();
            updatedFuncionario.setNome(funcionarioDetails.getNome());
            updatedFuncionario.setCpf(funcionarioDetails.getCpf());
            updatedFuncionario.setRg(funcionarioDetails.getRg());
            updatedFuncionario.setDataNascimento(funcionarioDetails.getDataNascimento());
            updatedFuncionario.setCargo(funcionarioDetails.getCargo());
            updatedFuncionario.setTelefone(funcionarioDetails.getTelefone());
            updatedFuncionario.setEndereco(funcionarioDetails.getEndereco());
            return ResponseEntity.ok(funcionarioRepository.save(updatedFuncionario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            funcionarioRepository.delete(funcionario.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}