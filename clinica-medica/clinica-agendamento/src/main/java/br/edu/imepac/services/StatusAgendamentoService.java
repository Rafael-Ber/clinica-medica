package br.edu.imepac.services;

import br.edu.imepac.models.StatusAgendamento;
import br.edu.imepac.repositories.StatusAgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StatusAgendamentoService {

    private final StatusAgendamentoRepository statusAgendamentoRepository;

    @Autowired
    public StatusAgendamentoService(StatusAgendamentoRepository statusAgendamentoRepository) {
        this.statusAgendamentoRepository = statusAgendamentoRepository;
    }

    public List<StatusAgendamento> listarTodos() {
        return statusAgendamentoRepository.findAll();
    }

    public StatusAgendamento buscarPorId(Long id) {
        Optional<StatusAgendamento> statusAgendamento = statusAgendamentoRepository.findById(id);
        return statusAgendamento.orElseThrow(() -> new IllegalArgumentException("Status de Agendamento não encontrado."));
    }

    public StatusAgendamento salvar(StatusAgendamento statusAgendamento) {
        return statusAgendamentoRepository.save(statusAgendamento);
    }

    public void deletar(Long id) {
        statusAgendamentoRepository.deleteById(id);
    }
}
