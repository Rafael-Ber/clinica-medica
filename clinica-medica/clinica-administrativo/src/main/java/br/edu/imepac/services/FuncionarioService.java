package br.edu.imepac.services;

import br.edu.imepac.models.Funcionario;
import br.edu.imepac.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> updateFuncionario(Long id, Funcionario funcionarioDetails) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioDetails.getNome());
            funcionario.setCpf(funcionarioDetails.getCpf());
            funcionario.setRg(funcionarioDetails.getRg());
            funcionario.setDataNascimento(funcionarioDetails.getDataNascimento());
            funcionario.setCargo(funcionarioDetails.getCargo());
            funcionario.setTelefone(funcionarioDetails.getTelefone());
            funcionario.setEndereco(funcionarioDetails.getEndereco());
            return funcionarioRepository.save(funcionario);
        });
    }

    public boolean deleteFuncionario(Long id) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionarioRepository.delete(funcionario);
            return true;
        }).orElse(false);
    }
}