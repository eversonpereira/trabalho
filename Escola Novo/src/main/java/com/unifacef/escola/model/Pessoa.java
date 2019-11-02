package com.unifacef.escola.model;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Autores:
 * Everson José de Freitas Pereira - Cod: 22304
 * Lucas Rafael Barbosa - Cod: 22314
 */

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idPessoa;

    @Column (name = "nome", length = 50)
    private String nome;

    @Column (name = "cpf", length = 11)
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nome, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
