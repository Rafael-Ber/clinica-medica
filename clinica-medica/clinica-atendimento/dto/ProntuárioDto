package br.edu.imepac.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ProntuarioDto {

    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDate dataAtendimento;
    private String diagnostico;
    private String tratamento;
    private String observacoes;

    // Construtores
    public ProntuarioDto() {
    }

    public ProntuarioDto(Long id, Long pacienteId, Long medicoId, LocalDate dataAtendimento, String diagnostico, String tratamento, String observacoes) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.dataAtendimento = dataAtendimento;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.observacoes = observacoes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProntuarioDto that = (ProntuarioDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pacienteId, that.pacienteId) &&
                Objects.equals(medicoId, that.medicoId) &&
                Objects.equals(dataAtendimento, that.dataAtendimento) &&
                Objects.equals(diagnostico, that.diagnostico) &&
                Objects.equals(tratamento, that.tratamento) &&
                Objects.equals(observacoes, that.observacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pacienteId, medicoId, dataAtendimento, diagnostico, tratamento, observacoes);
    }

    // toString
    @Override
    public String toString() {
        return "ProntuarioDto{" +
                "id=" + id +
                ", pacienteId=" + pacienteId +
                ", medicoId=" + medicoId +
                ", dataAtendimento=" + dataAtendimento +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamento='" + tratamento + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}