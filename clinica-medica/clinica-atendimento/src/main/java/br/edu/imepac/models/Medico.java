package br.edu.imepac.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String crm;

    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    private String telefone;
    private String email;
    private String endereco;

    // Construtores
    public Medico() {}

    public Medico(String nome, String crm, Especialidade especialidade, String telefone, String email, String endereco) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
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

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
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
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id) &&
                Objects.equals(nome, medico.nome) &&
                Objects.equals(crm, medico.crm) &&
                Objects.equals(especialidade, medico.especialidade) &&
                Objects.equals(telefone, medico.telefone) &&
                Objects.equals(email, medico.email) &&
                Objects.equals(endereco, medico.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, crm, especialidade, telefone, email, endereco);
    }

    // ToString
    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade=" + especialidade +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}