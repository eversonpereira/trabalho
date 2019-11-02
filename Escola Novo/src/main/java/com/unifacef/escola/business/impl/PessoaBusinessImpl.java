package com.unifacef.escola.business.impl;

import com.unifacef.escola.business.PessoaBusiness;
import com.unifacef.escola.error.ResourceNotFoundException;
import com.unifacef.escola.model.Pessoa;
import com.unifacef.escola.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaBusinessImpl<Public> implements PessoaBusiness {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaBusinessImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Page<Pessoa> findAll(Pageable pageable){
        return (Page<Pessoa>) pessoaRepository.findAll(pageable);
    }

    public Optional<Pessoa> findById(int id)
    {
        return pessoaRepository.findById(id);
    }

    public Pessoa save(Pessoa e) {
        return pessoaRepository.save(e);
    }

    public void deleteById(int id) {
        pessoaRepository.deleteById(id);
    }

    public Optional<Pessoa> updatePessoa(int id, Pessoa e){
        Optional<Pessoa> pe = pessoaRepository.findById(id);
        e.setIdPessoa(id);
        pessoaRepository.save(e);
        return Optional.of(e);
    }

    public void verificaPessoa(int id){
        if (pessoaRepository.findById(id).isPresent() == false)
            throw new ResourceNotFoundException("Pessoa não encontrada");
        }

    public Optional<Pessoa> findByNomeIgnoreCaseContaining(String nome){
        return pessoaRepository.findByNomeIgnoreCaseContaining(nome);
}
}
