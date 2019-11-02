package com.unifacef.escola.business;

import java.util.Optional;
import com.unifacef.escola.model.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MateriaBusiness {
    Page<Materia> findAll(Pageable pageable);
    Optional<Materia> findById(int id);
    Materia save(Materia e);
    void deleteById(int id);
    Optional<Materia> updateMateria(int id, Materia p);
    void verificaMateria(int id);
}
