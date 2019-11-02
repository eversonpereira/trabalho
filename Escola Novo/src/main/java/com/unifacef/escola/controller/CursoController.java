package com.unifacef.escola.controller;

import com.unifacef.escola.business.CursoBusiness;
import com.unifacef.escola.model.Curso;
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
@RequestMapping("/v1/cursos")
public class CursoController {

    private CursoBusiness cursoBusiness;

    @Autowired
    public CursoController(CursoBusiness cursoBusiness ){
        this.cursoBusiness = cursoBusiness;
    }

    @GetMapping
    public List<Curso> findAll(@RequestParam(defaultValue = "0", required = false) Integer numeroPagina){
        Pageable paging = PageRequest.of(numeroPagina, 10);
        Page<Curso> pagedResult = cursoBusiness.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Curso>();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> findby(@PathVariable int id){
        cursoBusiness.verificaCurso(id);
        return ResponseEntity.ok().body(cursoBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Curso> post(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoBusiness.save(curso));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        cursoBusiness.verificaCurso(id);
        cursoBusiness.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Curso> updateCurso(@PathVariable("id") int cursoId, @RequestBody Curso curso){
        cursoBusiness.verificaCurso(cursoId);
        cursoBusiness.updateCurso(cursoId, curso);
        return cursoBusiness.findById(cursoId);
    }

    @GetMapping("/buscaAlunoCurso/{nome}")
    public ResponseEntity<Optional<Curso>> findByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(cursoBusiness.findByTurmas_Aluno_Pessoa_NomeIgnoreCaseContaining(nome));
    }

}
