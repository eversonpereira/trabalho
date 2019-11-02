package com.unifacef.escola.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Autores:
 * Everson José de Freitas Pereira - Cod: 22304
 * Lucas Rafael Barbosa - Cod: 22314
 */

@Entity
@Table(name = "materia")
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idMateria;

    @Column (name = "descricao", length = 50)
    private String descricao;

    @OneToOne
    @JoinColumn(name = "idProfessor", referencedColumnName = "idProfessor")
    private Professor professor;

    @JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties("materias")
    private Curso curso;

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name="idCurso", referencedColumnName = "idCurso")
//    private Curso curso;

    public Materia() {
    }

    public Materia(int idMateria, String descricao, Professor professor, Curso curso) {
        this.idMateria = idMateria;
        this.descricao = descricao;
        this.professor = professor;
        this.curso = curso;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
