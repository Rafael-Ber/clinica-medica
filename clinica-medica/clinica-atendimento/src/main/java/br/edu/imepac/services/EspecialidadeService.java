package br.edu.imepac.services;

import br.edu.imepac.dto.EspecialidadeDto;
import br.edu.imepac.models.Especialidade;
import br.edu.imepac.repositories.EspecialidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EspecialidadeDto createEspecialidade(EspecialidadeDto especialidadeDto) {
        Especialidade especialidade = modelMapper.map(especialidadeDto, Especialidade.class);
        especialidade = especialidadeRepository.save(especialidade);
        return modelMapper.map(especialidade, EspecialidadeDto.class);
    }

    public List<EspecialidadeDto> getAllEspecialidades() {
        return especialidadeRepository.findAll().stream()
                .map(especialidade -> modelMapper.map(especialidade, EspecialidadeDto.class))
                .collect(Collectors.toList());
    }

    public EspecialidadeDto getEspecialidadeById(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
        return modelMapper.map(especialidade, EspecialidadeDto.class);
    }

    public EspecialidadeDto updateEspecialidade(Long id, EspecialidadeDto especialidadeDto) {
        Especialidade especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
        especialidade.setNome(especialidadeDto.getNome());
        especialidade.setDescricao(especialidadeDto.getDescricao());
        especialidade = especialidadeRepository.save(especialidade);
        return modelMapper.map(especialidade, EspecialidadeDto.class);
    }

    public void deleteEspecialidade(Long id) {
        Especialidade especialidade = especialidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
        especialidadeRepository.delete(especialidade);
    }
}
