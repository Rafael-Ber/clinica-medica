package br.edu.imepac.services;

import br.edu.imepac.models.Prontuario;
import br.edu.imepac.dto.ProntuarioDto;
import br.edu.imepac.repositories.ProntuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Prontuario> findAll() {
        return prontuarioRepository.findAll();
    }

    public Optional<Prontuario> findById(Long id) {
        return prontuarioRepository.findById(id);
    }

    public Prontuario save(Prontuario prontuario) {
        return prontuarioRepository.save(prontuario);
    }

    public void deleteById(Long id) {
        prontuarioRepository.deleteById(id);
    }

    public ProntuarioDto convertToDto(Prontuario prontuario) {
        return modelMapper.map(prontuario, ProntuarioDto.class);
    }

    public Prontuario convertToEntity(ProntuarioDto prontuarioDto) {
        return modelMapper.map(prontuarioDto, Prontuario.class);
    }

    public List<ProntuarioDto> findAllDtos() {
        return findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}