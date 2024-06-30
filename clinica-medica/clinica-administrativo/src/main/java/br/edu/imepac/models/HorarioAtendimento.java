package br.edu.imepac.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class HorarioAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime inicioAtendimento;
    private LocalTime fimAtendimento;
    private String diaSemana;

    public HorarioAtendimento() {
        // Construtor padrão
    }

    public HorarioAtendimento(Long id, LocalTime inicioAtendimento, LocalTime fimAtendimento, String diaSemana) {
        this.id = id;
        this.inicioAtendimento = inicioAtendimento;
        this.fimAtendimento = fimAtendimento;
        this.diaSemana = diaSemana;
    }

    public HorarioAtendimento(LocalTime inicioAtendimento, LocalTime fimAtendimento, String diaSemana) {
        this.inicioAtendimento = inicioAtendimento;
        this.fimAtendimento = fimAtendimento;
        this.diaSemana = diaSemana;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioAtendimento that = (HorarioAtendimento) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(inicioAtendimento, that.inicioAtendimento) &&
                Objects.equals(fimAtendimento, that.fimAtendimento) &&
                Objects.equals(diaSemana, that.diaSemana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inicioAtendimento, fimAtendimento, diaSemana);
    }

    @Override
    public String toString() {
        return "HorarioAtendimento{" +
                "id=" + id +
                ", inicioAtendimento=" + inicioAtendimento +
                ", fimAtendimento=" + fimAtendimento +
                ", diaSemana='" + diaSemana + '\'' +
                '}';
    }
}
