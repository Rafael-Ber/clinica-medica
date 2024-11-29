package br.edu.imepac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.imepac.models.StatusAgendamento;

@Repository
public interface StatusAgendamentoRepository extends JpaRepository<StatusAgendamento, Long> {

    // Aqui você pode adicionar métodos personalizados de consulta, se necessário

}
