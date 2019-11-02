package com.unifacef.escola.repository;

import com.unifacef.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer> {

    Optional<Aluno> findByPessoa_NomeIgnoreCaseContaining(String nome);
}
