package br.edu.imepac.dto;

import java.util.Objects;

public class FuncionarioDto {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String cargo;
    private String telefone;
    private String endereco;

    // Construtor padrão
    public FuncionarioDto() {}

    // Construtor com parâmetros
    public FuncionarioDto(Long id, String nome, String cpf, String rg, String dataNascimento, String cargo, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
        this.telefone = telefone;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        FuncionarioDto that = (FuncionarioDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(rg, that.rg) &&
                Objects.equals(dataNascimento, that.dataNascimento) &&
                Objects.equals(cargo, that.cargo) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, rg, dataNascimento, cargo, telefone, endereco);
    }

    // ToString
    @Override
    public String toString() {
        return "FuncionarioDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", cargo='" + cargo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}