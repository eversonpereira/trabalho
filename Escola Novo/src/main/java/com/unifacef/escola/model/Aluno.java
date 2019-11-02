package com.unifacef.escola.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Autores:
 * Everson José de Freitas Pereira - Cod: 22304
 * Lucas Rafael Barbosa - Cod: 22314
 */

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idAluno;

    @Column (name = "nomeSocial", length = 50)
    private String nomeSocial;

    @Column (name = "dataNascimento", length = 10)
    private Date dataNascimento;

    @OneToOne
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idTurma")
    private Turma turma;

    public Aluno() {
    }

    public Aluno(int idAluno, String nomeSocial, Date dataNascimento, Pessoa pessoa, Turma turma) {
        this.idAluno = idAluno;
        this.nomeSocial = nomeSocial;
        this.dataNascimento = dataNascimento;
        this.pessoa = pessoa;
        this.turma = turma;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
