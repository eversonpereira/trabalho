package com.unifacef.escola.business.impl;

import com.unifacef.escola.business.ProfessorBusiness;
import com.unifacef.escola.error.ResourceNotFoundException;
import com.unifacef.escola.model.Professor;
import com.unifacef.escola.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorBusinessImpl implements ProfessorBusiness {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorBusinessImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Page<Professor> findAll(Pageable pageable){
        return (Page<Professor>) professorRepository.findAll(pageable);
    }

    public Professor save(Professor e) {
        return professorRepository.save(e);
    }

    public Optional<Professor> findById(int id){
        return professorRepository.findById(id);
    }

    public void deleteById(int id) {
        professorRepository.deleteById(id);
    }

    public Optional<Professor> updateProfessor(int id, Professor e){
        Optional<Professor> pe = professorRepository.findById(id);
        e.setIdProfessor(id);
        professorRepository.save(e);
        return Optional.of(e);
    }

    public void verificaProfessor(int id){
        if (professorRepository.findById(id).isPresent() == false)
            throw new ResourceNotFoundException("Professor não encontrado");
    }

}
