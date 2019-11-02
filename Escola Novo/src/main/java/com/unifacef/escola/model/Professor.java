package com.unifacef.escola.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Autores:
 * Everson José de Freitas Pereira - Cod: 22304
 * Lucas Rafael Barbosa - Cod: 22314
 */

@Entity
@Table(name = "professor")
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idProfessor;

    @Column (name = "salario", length = 10)
    private double salario;

    @OneToOne
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;

    public Professor(int idProfessor, double salario, Pessoa pessoa) {
        this.idProfessor = idProfessor;
        this.salario = salario;
        this.pessoa = pessoa;
    }

    public Professor() {
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
