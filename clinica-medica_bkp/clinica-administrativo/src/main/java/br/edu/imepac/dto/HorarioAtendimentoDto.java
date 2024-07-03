package br.edu.imepac.dto;

import java.time.LocalTime;
import java.util.Objects;

public class HorarioAtendimentoDto {
    private Long id;
    private LocalTime inicioAtendimento;
    private LocalTime fimAtendimento;
    private String diaSemana;

    // Construtor padrão
    public HorarioAtendimentoDto() {}

    // Construtor com parâmetros
    public HorarioAtendimentoDto(Long id, LocalTime inicioAtendimento, LocalTime fimAtendimento, String diaSemana) {
        this.id = id;
        this.inicioAtendimento = inicioAtendimento;
        this.fimAtendimento = fimAtendimento;
        this.diaSemana = diaSemana;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getInicioAtendimento() {
        return inicioAtendimento;
    }

    public void setInicioAtendimento(LocalTime inicioAtendimento) {
        this.inicioAtendimento = inicioAtendimento;
    }

    public LocalTime getFimAtendimento() {
        return fimAtendimento;
    }

    public void setFimAtendimento(LocalTime fimAtendimento) {
        this.fimAtendimento = fimAtendimento;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioAtendimentoDto that = (HorarioAtendimentoDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(inicioAtendimento, that.inicioAtendimento) &&
                Objects.equals(fimAtendimento, that.fimAtendimento) &&
                Objects.equals(diaSemana, that.diaSemana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inicioAtendimento, fimAtendimento, diaSemana);
    }

    // ToString
    @Override
    public String toString() {
        return "HorarioAtendimentoDto{" +
                "id=" + id +
                ", inicioAtendimento=" + inicioAtendimento +
                ", fimAtendimento=" + fimAtendimento +
                ", diaSemana='" + diaSemana + '\'' +
                '}';
    }
}