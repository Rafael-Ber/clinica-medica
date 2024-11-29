package br.edu.imepac.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AgendamentoDto {
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;
    private String status;

    // Construtores
    public AgendamentoDto() {
    }

    public AgendamentoDto(Long id, Long pacienteId, Long medicoId, LocalDate dataAgendamento, LocalTime horaAgendamento, String status) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.dataAgendamento = dataAgendamento;
        this.horaAgendamento = horaAgendamento;
        this.status = status;
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

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalTime getHoraAgendamento() {
        return horaAgendamento;
    }

    public void setHoraAgendamento(LocalTime horaAgendamento) {
        this.horaAgendamento = horaAgendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendamentoDto that = (AgendamentoDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pacienteId, that.pacienteId) &&
                Objects.equals(medicoId, that.medicoId) &&
                Objects.equals(dataAgendamento, that.dataAgendamento) &&
                Objects.equals(horaAgendamento, that.horaAgendamento) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pacienteId, medicoId, dataAgendamento, horaAgendamento, status);
    }

    // toString
    @Override
    public String toString() {
        return "AgendamentoDto{" +
                "id=" + id +
                ", pacienteId=" + pacienteId +
                ", medicoId=" + medicoId +
                ", dataAgendamento=" + dataAgendamento +
                ", horaAgendamento=" + horaAgendamento +
                ", status='" + status + '\'' +
                '}';
    }
}