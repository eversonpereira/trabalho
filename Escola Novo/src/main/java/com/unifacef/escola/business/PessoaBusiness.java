package com.unifacef.escola.business;

import com.unifacef.escola.model.Pessoa;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface PessoaBusiness {
    Page<Pessoa> findAll(Pageable pageable);
    Optional<Pessoa> findById(int id);
    Pessoa save(Pessoa e);
    void deleteById(int id);
    Optional<Pessoa> updatePessoa(int id, Pessoa p);
    void verificaPessoa(int id);
    Optional<Pessoa> findByNomeIgnoreCaseContaining(String nome);
}
