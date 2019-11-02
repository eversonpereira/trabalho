package com.unifacef.escola.business;

import com.unifacef.escola.model.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProfessorBusiness {
    Page<Professor> findAll(Pageable pageable);
    Optional<Professor> findById(int id);
    Professor save(Professor e);
    void deleteById(int id);
    Optional<Professor> updateProfessor(int id, Professor p);
    void verificaProfessor(int id);
}
