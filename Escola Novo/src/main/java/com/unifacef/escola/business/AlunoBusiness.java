package com.unifacef.escola.business;

import java.util.Optional;
import com.unifacef.escola.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoBusiness {
    Page<Aluno> findAll(Pageable pageable);
    Optional<Aluno> findById(int id);
    Aluno save(Aluno e);
    void deleteById(int id);
    Optional<Aluno> updateAluno(int id, Aluno p);
    void verificaAluno(int id);
    Optional<Aluno> findByPessoa_NomeIgnoreCaseContaining(String nome);
}
