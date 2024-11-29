package br.edu.imepac.dto;

import java.time.LocalDate;

public class PacienteDto {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String telefone;

    // Construtores, getters e setters

    public PacienteDto() {
    }

    public PacienteDto(Long id, String nome, String email, LocalDate dataNascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
