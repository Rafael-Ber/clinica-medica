package br.edu.imepac.services;

import br.edu.imepac.models.Especialidade;
import br.edu.imepac.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> findAll() {
        return especialidadeRepository.findAll();
    }

    public Optional<Especialidade> findById(Long id) {
        return especialidadeRepository.findById(id);
    }

    public Especialidade save(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public void deleteById(Long id) {
        especialidadeRepository.deleteById(id);
    }
}
