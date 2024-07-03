package br.edu.imepac.repositories;

import br.edu.imepac.models.HorarioAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioAtendimentoRepository extends JpaRepository<HorarioAtendimento, Long> {
}
