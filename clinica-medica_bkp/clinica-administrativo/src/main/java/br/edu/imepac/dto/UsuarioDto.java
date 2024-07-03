package br.edu.imepac.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipo;
    private LocalDateTime dataCriacao;

    // Construtor padrão
    public UsuarioDto() {}

    // Construtor com parâmetros
    public UsuarioDto(Long id, String nome, String email, String senha, TipoUsuario tipo, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto that = (UsuarioDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(senha, that.senha) &&
                tipo == that.tipo &&
                Objects.equals(dataCriacao, that.dataCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, tipo, dataCriacao);
    }

    // ToString
    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", tipo=" + tipo +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    public enum TipoUsuario {
        ADMINISTRADOR, FUNCIONARIO
    }

    // Métodos de conversão
    public static TipoUsuario toDtoTipo(br.edu.imepac.models.Usuario.TipoUsuario tipo) {
        return TipoUsuario.valueOf(tipo.name());
    }

    public static br.edu.imepac.models.Usuario.TipoUsuario toEntityTipo(TipoUsuario tipo) {
        return br.edu.imepac.models.Usuario.TipoUsuario.valueOf(tipo.name());
    }
}