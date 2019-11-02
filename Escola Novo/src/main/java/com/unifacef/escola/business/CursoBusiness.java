package com.unifacef.escola.business;

import java.util.Optional;
import com.unifacef.escola.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CursoBusiness {
    Page<Curso> findAll(Pageable pageable);
    Optional<Curso> findById(int id);
    Curso save(Curso e);
    void deleteById(int id);
    Optional<Curso> updateCurso(int id, Curso p);
    void verificaCurso(int id);
    Optional<Curso> findByTurmas_Aluno_Pessoa_NomeIgnoreCaseContaining(String nome);
}
