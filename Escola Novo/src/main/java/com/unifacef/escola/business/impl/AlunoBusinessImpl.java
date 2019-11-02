package com.unifacef.escola.business.impl;

import com.unifacef.escola.business.AlunoBusiness;
import com.unifacef.escola.error.ResourceNotFoundException;
import com.unifacef.escola.model.Aluno;
import com.unifacef.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AlunoBusinessImpl implements AlunoBusiness {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoBusinessImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Page<Aluno> findAll(Pageable pageable){
        return (Page<Aluno>) alunoRepository.findAll(pageable);
    }

    public Optional<Aluno> findById(int id){
        return alunoRepository.findById(id);
    }

    public Aluno save(Aluno e) {
        return alunoRepository.save(e);
    }

    public void deleteById(int id) {
        alunoRepository.deleteById(id);
    }

    public Optional<Aluno> updateAluno(int id, Aluno e){
        Optional<Aluno> pe = alunoRepository.findById(id);
        e.setIdAluno(id);
        alunoRepository.save(e);
        return Optional.of(e);
    }

    public void verificaAluno(int id){
        if (alunoRepository.findById(id).isPresent() == false)
            throw new ResourceNotFoundException("Aluno não encontrado");
    }

    public Optional<Aluno> findByPessoa_NomeIgnoreCaseContaining(String nome){
        return alunoRepository.findByPessoa_NomeIgnoreCaseContaining(nome);
    }
}
