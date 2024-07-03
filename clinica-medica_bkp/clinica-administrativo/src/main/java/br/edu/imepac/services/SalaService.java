package br.edu.imepac.services;

import br.edu.imepac.models.Sala;
import br.edu.imepac.dto.SalaDto;
import br.edu.imepac.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    // Método para converter Sala para SalaDTO
    private SalaDto convertToDTO(Sala sala) {
        return new SalaDto(sala.getId(), sala.getNumero(), sala.getDescricao(), sala.getCapacidade());
    }

    // Método para converter SalaDTO para Sala
    private Sala convertToEntity(SalaDto salaDTO) {
        return new Sala(salaDTO.getId(), salaDTO.getCapacidade(), salaDTO.getDescricao(), salaDTO.getNumero());
    }

    // Método para obter todas as salas
    public List<SalaDto> getAllSalas() {
        return salaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Método para obter uma sala por ID
    public SalaDto getSalaById(Long id) {
        Optional<Sala> sala = salaRepository.findById(id);
        return sala.map(this::convertToDTO).orElse(null);
    }

    // Método para criar uma nova sala
    public SalaDto createSala(SalaDto salaDTO) {
        Sala sala = convertToEntity(salaDTO);
        Sala savedSala = salaRepository.save(sala);
        return convertToDTO(savedSala);
    }

    // Método para atualizar uma sala existente
    public SalaDto updateSala(Long id, SalaDto salaDTO) {
        Optional<Sala> existingSala = salaRepository.findById(id);
        if (existingSala.isPresent()) {
            Sala sala = convertToEntity(salaDTO);
            sala.setId(id);
            Sala updatedSala = salaRepository.save(sala);
            return convertToDTO(updatedSala);
        } else {
            return null;
        }
    }

    // Método para deletar uma sala por ID
    public void deleteSala(Long id) {
        salaRepository.deleteById(id);
    }
}