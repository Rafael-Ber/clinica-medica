package br.edu.imepac.dto;

import java.time.LocalDate;

public class MedicoDto {

    private Long id;
    private String nome;
    private String especialidade;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    // Construtor vazio
    public MedicoDto() {
    }

    // Construtor completo
    public MedicoDto(Long id, String nome, String especialidade, LocalDate dataNascimento, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Equals e HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicoDto medicoDto = (MedicoDto) o;

        if (!id.equals(medicoDto.id)) return false;
        if (!nome.equals(medicoDto.nome)) return false;
        if (!especialidade.equals(medicoDto.especialidade)) return false;
        if (!dataNascimento.equals(medicoDto.dataNascimento)) return false;
        if (!telefone.equals(medicoDto.telefone)) return false;
        return email.equals(medicoDto.email);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + especialidade.hashCode();
        result = 31 * result + dataNascimento.hashCode();
        result = 31 * result + telefone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    // ToString

    @Override
    public String toString() {
        return "MedicoDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
