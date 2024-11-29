package br.edu.imepac.services;


import br.edu.imepac.dto.PrescricaoDto;
import br.edu.imepac.models.Prescricao;
import br.edu.imepac.repositories.PrescricaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrescricaoService {

    @Autowired
    private PrescricaoRepository prescricaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PrescricaoDto convertToDto(Prescricao prescricao) {
        return modelMapper.map(prescricao, PrescricaoDto.class);
    }

    public Prescricao convertToEntity(PrescricaoDto prescricaoDto) {
        return modelMapper.map(prescricaoDto, Prescricao.class);
    }

    public List<PrescricaoDto> findAll() {
        return prescricaoRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<PrescricaoDto> findById(Long id) {
        return prescricaoRepository.findById(id).map(this::convertToDto);
    }

    public Prescricao save(Prescricao prescricao) {
        return prescricaoRepository.save(prescricao);
    }

    public void deleteById(Long id) {
        prescricaoRepository.deleteById(id);
    }
}
