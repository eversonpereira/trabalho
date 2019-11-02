package com.unifacef.escola.business;


import java.util.Optional;
import com.unifacef.escola.model.Turma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TurmaBusiness {
    Page<Turma> findAll(Pageable pageable);
    Optional<Turma> findById(int id);
    Turma save(Turma e);
    void deleteById(int id);
    Optional<Turma> updateTurma(int id, Turma p);
    void verificaTurma(int id);
    Optional<Turma> findByAluno_Pessoa_NomeIgnoreCaseContaining(String nome);
}
