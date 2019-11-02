package com.unifacef.escola.controller;

import com.unifacef.escola.business.ProfessorBusiness;
import com.unifacef.escola.model.Professor;
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
@RequestMapping("/v1/professores")
public class ProfessorController {

    private ProfessorBusiness professorBusiness;

    @Autowired
    public ProfessorController(ProfessorBusiness professorBusiness) {
        this.professorBusiness = professorBusiness;
    }

    @GetMapping
    public List<Professor> findAll(@RequestParam(defaultValue = "0", required = false) Integer numeroPagina){
        Pageable paging = PageRequest.of(numeroPagina, 10);
        Page<Professor> pagedResult = professorBusiness.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Professor>();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Professor>> findBy(@PathVariable int id) {
        professorBusiness.verificaProfessor(id);
        return ResponseEntity.ok().body(professorBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Professor> post(@RequestBody Professor professor){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorBusiness.save(professor));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        professorBusiness.verificaProfessor(id);
        professorBusiness.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Professor> updateProfessor(@PathVariable("id") int professorId, @RequestBody Professor professor){
        professorBusiness.verificaProfessor(professorId);
        professorBusiness.updateProfessor(professorId, professor);
        return professorBusiness.findById(professorId);
    }
}
