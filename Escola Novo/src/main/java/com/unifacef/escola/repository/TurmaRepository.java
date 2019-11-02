package com.unifacef.escola.repository;

import com.unifacef.escola.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma,Integer> {

    Optional<Turma> findByAluno_Pessoa_NomeIgnoreCaseContaining(String nome);

}
