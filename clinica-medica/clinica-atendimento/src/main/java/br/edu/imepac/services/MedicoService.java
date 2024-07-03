package br.edu.imepac.services;

import br.edu.imepac.models.Medico;
import br.edu.imepac.repositories.MedicoRepository;
import br.edu.imepac.dto.MedicoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository, ModelMapper modelMapper) {
        this.medicoRepository = medicoRepository;
        this.modelMapper = modelMapper;
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Long id) {
        return medicoRepository.findById(id);
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

    public MedicoDto convertToDto(Medico medico) {
        return modelMapper.map(medico, MedicoDto.class);
    }

    public Medico convertToEntity(MedicoDto medicoDto) {
        return modelMapper.map(medicoDto, Medico.class);
    }

    public List<MedicoDto> convertToDtoList(List<Medico> medicos) {
        return medicos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
