package br.edu.imepac.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ExameDto {

    private Long id;
    private Long prontuarioId;
    private String tipo;
    private String resultado;
    private LocalDate dataRealizacao;

    // Construtores
    public ExameDto() {
    }

    public ExameDto(Long id, Long prontuarioId, String tipo, String resultado, LocalDate dataRealizacao) {
        this.id = id;
        this.prontuarioId = prontuarioId;
        this.tipo = tipo;
        this.resultado = resultado;
        this.dataRealizacao = dataRealizacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExameDto exameDto = (ExameDto) o;
        return Objects.equals(id, exameDto.id) &&
                Objects.equals(prontuarioId, exameDto.prontuarioId) &&
                Objects.equals(tipo, exameDto.tipo) &&
                Objects.equals(resultado, exameDto.resultado) &&
                Objects.equals(dataRealizacao, exameDto.dataRealizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prontuarioId, tipo, resultado, dataRealizacao);
    }

    // toString
    @Override
    public String toString() {
        return "ExameDto{" +
                "id=" + id +
                ", prontuarioId=" + prontuarioId +
                ", tipo='" + tipo + '\'' +
                ", resultado='" + resultado + '\'' +
                ", dataRealizacao=" + dataRealizacao +
                '}';
    }
}