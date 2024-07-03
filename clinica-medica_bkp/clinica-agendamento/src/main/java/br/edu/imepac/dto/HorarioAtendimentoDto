package br.edu.imepac.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class HorarioAtendimentoDto {
    private Long id;
    private Long medicoId;
    private DayOfWeek diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    // Construtores
    public HorarioAtendimentoDto() {
    }

    public HorarioAtendimentoDto(Long id, Long medicoId, DayOfWeek diaSemana, LocalTime horaInicio, LocalTime horaFim) {
        this.id = id;
        this.medicoId = medicoId;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioAtendimentoDto that = (HorarioAtendimentoDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(medicoId, that.medicoId) &&
                diaSemana == that.diaSemana &&
                Objects.equals(horaInicio, that.horaInicio) &&
                Objects.equals(horaFim, that.horaFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicoId, diaSemana, horaInicio, horaFim);
    }

    // toString
    @Override
    public String toString() {
        return "HorarioAtendimentoDto{" +
                "id=" + id +
                ", medicoId=" + medicoId +
                ", diaSemana=" + diaSemana +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }
}