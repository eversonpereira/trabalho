package com.unifacef.escola.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Autores:
 * Everson José de Freitas Pereira - Cod: 22304
 * Lucas Rafael Barbosa - Cod: 22314
 */

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idTurma;

    @Column
    private String descricao;

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
//    private Curso curso;

    @JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties("turmas")
    private Curso curso;

    @JsonManagedReference
    @OneToMany(mappedBy = "turma")
    @ElementCollection
    @OrderBy("nomeSocial")
    private Set<Aluno> aluno;

    public Turma() {
    }

    public Turma(String descricao, Curso curso, Set<Aluno> aluno) {
        this.descricao = descricao;
        this.curso = curso;
        this.aluno = aluno;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(Set<Aluno> aluno) {
        this.aluno = aluno;
    }
}

