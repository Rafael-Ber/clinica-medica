package br.edu.imepac.dto;

import java.util.Objects;

public class SalaDto {
    private Long id;
    private String numero;
    private String descricao;
    private int capacidade;

    // Construtor padrão
    public SalaDto() {}

    // Construtor com parâmetros
    public SalaDto(Long id, String numero, String descricao, int capacidade) {
        this.id = id;
        this.numero = numero;
        this.descricao = descricao;
        this.capacidade = capacidade;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaDto salaDTO = (SalaDto) o;
        return capacidade == salaDTO.capacidade && Objects.equals(id, salaDTO.id) && Objects.equals(numero, salaDTO.numero) && Objects.equals(descricao, salaDTO.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, descricao, capacidade);
    }

    // ToString
    @Override
    public String toString() {
        return "SalaDTO{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}