package br.edu.imepac.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prontuario_id", nullable = false)
    private Prontuario prontuario;

    private String tipo;
    private String resultado;
    private LocalDate dataRealizacao;

    // Construtores
    public Exame() {
    }

    public Exame(Prontuario prontuario, String tipo, String resultado, LocalDate dataRealizacao) {
        this.prontuario = prontuario;
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

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
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
        Exame exame = (Exame) o;
        return Objects.equals(id, exame.id) &&
                Objects.equals(prontuario, exame.prontuario) &&
                Objects.equals(tipo, exame.tipo) &&
                Objects.equals(resultado, exame.resultado) &&
                Objects.equals(dataRealizacao, exame.dataRealizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prontuario, tipo, resultado, dataRealizacao);
    }

    // toString
    @Override
    public String toString() {
        return "Exame{" +
                "id=" + id +
                ", prontuario=" + prontuario +
                ", tipo='" + tipo + '\'' +
                ", resultado='" + resultado + '\'' +
                ", dataRealizacao=" + dataRealizacao +
                '}';
    }
}