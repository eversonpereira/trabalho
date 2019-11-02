package com.unifacef.escola.repository;

import com.unifacef.escola.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
    Optional<Pessoa> findByNomeIgnoreCaseContaining(String nome);
}

