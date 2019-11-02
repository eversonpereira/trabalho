package com.unifacef.escola.repository;

import com.unifacef.escola.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia,Integer> {
}
