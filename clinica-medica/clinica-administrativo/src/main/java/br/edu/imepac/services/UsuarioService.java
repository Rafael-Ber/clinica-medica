package br.edu.imepac.services;

import br.edu.imepac.models.Usuario;
import br.edu.imepac.dto.UsuarioDto;
import br.edu.imepac.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para converter Usuario para UsuarioDTO
    private UsuarioDto convertToDTO(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                UsuarioDto.toDtoTipo(usuario.getTipo()),
                usuario.getDataCriacao()
        );
    }

    // Método para converter UsuarioDTO para Usuario
    private Usuario convertToEntity(UsuarioDto usuarioDTO) {
        return new Usuario(
                usuarioDTO.getNome(),
                usuarioDTO.getId(),
                usuarioDTO.getEmail(),
                usuarioDTO.getSenha(),
                UsuarioDto.toEntityTipo(usuarioDTO.getTipo())
        );
    }

    // Método para obter todos os usuários
    public List<UsuarioDto> getAllUsuarios() {
        return usuarioRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Método para obter um usuário por ID
    public UsuarioDto getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(this::convertToDTO).orElse(null);
    }

    // Método para criar um novo usuário
    public UsuarioDto createUsuario(UsuarioDto usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return convertToDTO(savedUsuario);
    }

    // Método para atualizar um usuário existente
    public UsuarioDto updateUsuario(Long id, UsuarioDto usuarioDTO) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()) {
            Usuario usuario = convertToEntity(usuarioDTO);
            usuario.setId(id);
            Usuario updatedUsuario = usuarioRepository.save(usuario);
            return convertToDTO(updatedUsuario);
        } else {
            return null;
        }
    }

    // Método para deletar um usuário por ID
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}