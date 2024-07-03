package br.edu.imepac.services;

import br.edu.imepac.models.HorarioAtendimento;
import br.edu.imepac.repositories.HorarioAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioAtendimentoService {

    private final HorarioAtendimentoRepository horarioAtendimentoRepository;

    @Autowired
    public HorarioAtendimentoService(HorarioAtendimentoRepository horarioAtendimentoRepository) {
        this.horarioAtendimentoRepository = horarioAtendimentoRepository;
    }

    public List<HorarioAtendimento> findAll() {
        return horarioAtendimentoRepository.findAll();
    }

    public Optional<HorarioAtendimento> findById(Long id) {
        return horarioAtendimentoRepository.findById(id);
    }

    public HorarioAtendimento save(HorarioAtendimento horarioAtendimento) {
        return horarioAtendimentoRepository.save(horarioAtendimento);
    }

    public void deleteById(Long id) {
        horarioAtendimentoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return horarioAtendimentoRepository.existsById(id);
    }
}
