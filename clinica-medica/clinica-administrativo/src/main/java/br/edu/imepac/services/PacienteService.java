package br.edu.imepac.services;

import br.edu.imepac.models.Paciente;
import br.edu.imepac.repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.imepac.dto.PacienteDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

    public PacienteDto convertToDto(Paciente paciente) {
        return modelMapper.map(paciente, PacienteDto.class);
    }

    public Paciente convertToEntity(PacienteDto pacienteDto) {
        return modelMapper.map(pacienteDto, Paciente.class);
    }

    public List<PacienteDto> convertToDtoList(List<Paciente> pacientes) {
        return pacientes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
