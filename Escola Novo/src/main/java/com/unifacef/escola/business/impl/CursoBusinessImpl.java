package com.unifacef.escola.business.impl;

import com.unifacef.escola.business.CursoBusiness;
import com.unifacef.escola.error.ResourceNotFoundException;
import com.unifacef.escola.model.Curso;
import com.unifacef.escola.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CursoBusinessImpl implements CursoBusiness {

    private CursoRepository cursoRepository;

    @Autowired
    public CursoBusinessImpl(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public Page<Curso> findAll(Pageable pageable){
        return (Page<Curso>) cursoRepository.findAll(pageable);
    }

    public Optional<Curso> findById(int id){
        return cursoRepository.findById(id);
    }

    public Curso save(Curso e) {
        return cursoRepository.save(e);
    }

    public void deleteById(int id) {
        cursoRepository.deleteById(id);
    }

    public Optional<Curso> updateCurso(int id, Curso e){
        Optional<Curso> pe = cursoRepository.findById(id);
        e.setIdCurso(id);
        cursoRepository.save(e);
        return Optional.of(e);
    }

    public void verificaCurso(int id){
        if (cursoRepository.findById(id).isPresent() == false)
            throw new ResourceNotFoundException("Curso não encontrado!");
    }

    public Optional<Curso> findByTurmas_Aluno_Pessoa_NomeIgnoreCaseContaining(String nome){
        return cursoRepository.findByTurmas_Aluno_Pessoa_NomeIgnoreCaseContaining(nome);
    }

}
