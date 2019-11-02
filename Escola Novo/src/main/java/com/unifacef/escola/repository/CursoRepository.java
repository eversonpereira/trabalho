package com.unifacef.escola.repository;

import com.unifacef.escola.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {

    Optional<Curso> findByTurmas_Aluno_Pessoa_NomeIgnoreCaseContaining(String nome);

}
