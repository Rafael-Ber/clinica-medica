package br.edu.imepac.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAgendamento;
    private String descricao;

    public Agendamento() {
        // Construtor padrão
    }

    public Agendamento(LocalDateTime dataAgendamento, String descricao) {
        this.dataAgendamento = dataAgendamento;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agendamento that = (Agendamento) o;

        if (!id.equals(that.id)) return false;
        if (!dataAgendamento.equals(that.dataAgendamento)) return false;
        return descricao.equals(that.descricao);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + dataAgendamento.hashCode();
        result = 31 * result + descricao.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", dataAgendamento=" + dataAgendamento +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
