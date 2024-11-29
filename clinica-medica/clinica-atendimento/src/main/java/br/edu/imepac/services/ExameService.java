package br.edu.imepac.services;

import br.edu.imepac.models.Exame;
import br.edu.imepac.repositories.ExameRepository;
import br.edu.imepac.dto.ExameDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExameService {

    private final ExameRepository exameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ExameService(ExameRepository exameRepository, ModelMapper modelMapper) {
        this.exameRepository = exameRepository;
        this.modelMapper = modelMapper;
    }

    public List<Exame> findAll() {
        return exameRepository.findAll();
    }

    public Optional<Exame> findById(Long id) {
        return exameRepository.findById(id);
    }

    public Exame save(Exame exame) {
        return exameRepository.save(exame);
    }

    public void deleteById(Long id) {
        exameRepository.deleteById(id);
    }

    public ExameDto convertToDto(Exame exame) {
        return modelMapper.map(exame, ExameDto.class);
    }

    public Exame convertToEntity(ExameDto exameDto) {
        return modelMapper.map(exameDto, Exame.class);
    }

    public List<ExameDto> convertToDtoList(List<Exame> exames) {
        return exames.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}