package br.edu.imepac.dto;

import java.util.Objects;

public class MedicoDto {

    private Long id;
    private String nome;
    private String crm;
    private Long especialidadeId;
    private String telefone;
    private String email;
    private String endereco;

    // Construtores
    public MedicoDto() {}

    public MedicoDto(Long id, String nome, String crm, Long especialidadeId, String telefone, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especialidadeId = especialidadeId;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Getters e Setters
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Long getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Long especialidadeId) {
        this.especialidadeId = especialidadeId;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicoDto medicoDto = (MedicoDto) o;
        return Objects.equals(id, medicoDto.id) && Objects.equals(nome, medicoDto.nome) && Objects.equals(crm, medicoDto.crm) && Objects.equals(especialidadeId, medicoDto.especialidadeId) && Objects.equals(telefone, medicoDto.telefone) && Objects.equals(email, medicoDto.email) && Objects.equals(endereco, medicoDto.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, crm, especialidadeId, telefone, email, endereco);
    }

    // ToString
    @Override
    public String toString() {
        return "MedicoDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidadeId=" + especialidadeId +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}