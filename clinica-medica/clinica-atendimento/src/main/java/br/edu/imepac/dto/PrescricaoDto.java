package br.edu.imepac.dto;

import java.util.Objects;

public class PrescricaoDto {

    private Long id;
    private Long prontuarioId;
    private String medicamento;
    private String dosagem;
    private String frequencia;
    private String duracao;

    // Construtores
    public PrescricaoDto() {
    }

    public PrescricaoDto(Long id, Long prontuarioId, String medicamento, String dosagem, String frequencia, String duracao) {
        this.id = id;
        this.prontuarioId = prontuarioId;
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.duracao = duracao;
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

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescricaoDto that = (PrescricaoDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(prontuarioId, that.prontuarioId) &&
                Objects.equals(medicamento, that.medicamento) &&
                Objects.equals(dosagem, that.dosagem) &&
                Objects.equals(frequencia, that.frequencia) &&
                Objects.equals(duracao, that.duracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prontuarioId, medicamento, dosagem, frequencia, duracao);
    }

    // toString
    @Override
    public String toString() {
        return "PrescricaoDto{" +
                "id=" + id +
                ", prontuarioId=" + prontuarioId +
                ", medicamento='" + medicamento + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", frequencia='" + frequencia + '\'' +
                ", duracao='" + duracao + '\'' +
                '}';
    }
}