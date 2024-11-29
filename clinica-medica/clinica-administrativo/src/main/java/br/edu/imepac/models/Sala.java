package br.edu.imepac.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String descricao;
    private int capacidade;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Construtores, equals, hashCode, toString


    public Sala(Long id, int capacidade, String descricao, String numero) {
        this.id = id;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return getCapacidade() == sala.getCapacidade() && Objects.equals(getId(), sala.getId()) && Objects.equals(getNumero(), sala.getNumero()) && Objects.equals(getDescricao(), sala.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumero(), getDescricao(), getCapacidade());
    }
}
