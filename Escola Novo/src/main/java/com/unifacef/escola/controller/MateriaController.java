package com.unifacef.escola.controller;

import com.unifacef.escola.business.MateriaBusiness;
import com.unifacef.escola.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Autores:
 * Everson José de Freitas Pereira - Cod: 22304
 * Lucas Rafael Barbosa - Cod: 22314
 */


@RestController
@RequestMapping("/v1/materias")
public class MateriaController {

    private MateriaBusiness materiaBusiness;

    @Autowired
    public MateriaController(MateriaBusiness materiaBusiness ){
        this.materiaBusiness = materiaBusiness;
    }

    @GetMapping
    public List<Materia> findAll(@RequestParam(defaultValue = "0", required = false) Integer numeroPagina){
        Pageable paging = PageRequest.of(numeroPagina, 10);
        Page<Materia> pagedResult = materiaBusiness.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Materia>();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Materia>> findby(@PathVariable int id){
        materiaBusiness.verificaMateria(id);
        return ResponseEntity.ok().body(materiaBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Materia> post(@RequestBody Materia materia){
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaBusiness.save(materia));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        materiaBusiness.verificaMateria(id);
        materiaBusiness.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Materia> updateMateria(@PathVariable("id") int materiaId, @RequestBody Materia materia){
        materiaBusiness.verificaMateria(materiaId);
        materiaBusiness.updateMateria(materiaId, materia);
        return materiaBusiness.findById(materiaId);
    }
}
