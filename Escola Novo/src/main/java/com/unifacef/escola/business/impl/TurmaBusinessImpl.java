package com.unifacef.escola.business.impl;

import com.unifacef.escola.business.TurmaBusiness;
import com.unifacef.escola.error.ResourceNotFoundException;
import com.unifacef.escola.model.Turma;
import com.unifacef.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaBusinessImpl implements TurmaBusiness {
    private TurmaRepository turmaRepository;

    @Autowired
    public TurmaBusinessImpl(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Page<Turma> findAll(Pageable pageable){
        return (Page<Turma>) turmaRepository.findAll(pageable);
    }

    public Turma save(Turma e) {
        return turmaRepository.save(e);
    }

    public Optional<Turma> findById(int id){
        return turmaRepository.findById(id);
    }

    public void deleteById(int id) {
        turmaRepository.deleteById(id);
    }

    public Optional<Turma> updateTurma(int id, Turma e){
        Optional<Turma> pe = turmaRepository.findById(id);
        e.setIdTurma(id);
        turmaRepository.save(e);
        return Optional.of(e);
    }

    public void verificaTurma(int id){
        if (turmaRepository.findById(id).isPresent() == false)
            throw new ResourceNotFoundException("Turma não encontrado!");
    }

    public Optional<Turma> findByAluno_Pessoa_NomeIgnoreCaseContaining(String nome){
        return turmaRepository.findByAluno_Pessoa_NomeIgnoreCaseContaining(nome);
    }

}
