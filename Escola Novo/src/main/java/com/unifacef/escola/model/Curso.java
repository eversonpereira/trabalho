package com.unifacef.escola.model;

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
@Table(name = "curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idCurso;

    @Column
    private String descricao;

    @JsonManagedReference
    //@OneToMany(mappedBy = "idMateria")
    @OneToMany(mappedBy = "curso")
    private Set<Materia> materias;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "idTurma")
//    private Set<Turma> turmas;

    @JsonManagedReference
    @OneToMany(mappedBy = "curso")
    private Set<Turma> turmas;

    public Curso() {
    }

    public Curso(String descricao, Set<Materia> materias, Set<Turma> turmas) {
        this.descricao = descricao;
        this.materias = materias;
        this.turmas = turmas;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }
}
