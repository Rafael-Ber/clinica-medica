package br.edu.imepac.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class AgendamentoDto {
    private Long id;
    private LocalDateTime dataAgendamento;
    private String descricao;

    // Construtor padrão
    public AgendamentoDto() {}

    // Construtor com parâmetros
    public AgendamentoDto(Long id, LocalDateTime dataAgendamento, String descricao) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.descricao = descricao;
    }

    // Getters e Setters
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

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendamentoDto that = (AgendamentoDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataAgendamento, that.dataAgendamento) &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataAgendamento, descricao);
    }

    // ToString
    @Override
    public String toString() {
        return "AgendamentoDto{" +
                "id=" + id +
                ", dataAgendamento=" + dataAgendamento +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}