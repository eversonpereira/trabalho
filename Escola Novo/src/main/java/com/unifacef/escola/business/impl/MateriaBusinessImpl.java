package com.unifacef.escola.business.impl;

import com.unifacef.escola.business.MateriaBusiness;
import com.unifacef.escola.error.ResourceNotFoundException;
import com.unifacef.escola.model.Materia;
import com.unifacef.escola.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaBusinessImpl implements MateriaBusiness {

    private MateriaRepository materiaRepository;

    @Autowired
    public MateriaBusinessImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public Page<Materia> findAll(Pageable pageable){
        return (Page<Materia>) materiaRepository.findAll(pageable);
    }

    public Optional<Materia> findById(int id){
        return materiaRepository.findById(id);
    }

    public Materia save(Materia e) {
        return materiaRepository.save(e);
    }

    public void deleteById(int id) {
        materiaRepository.deleteById(id);
    }

    public Optional<Materia> updateMateria(int id, Materia e){
        Optional<Materia> pe = materiaRepository.findById(id);
        e.setIdMateria(id);
        materiaRepository.save(e);
        return Optional.of(e);
    }

    public void verificaMateria(int id){
        if (materiaRepository.findById(id).isPresent() == false)
            throw new ResourceNotFoundException("Materia não encontrada");
    }

}
