package com.unifacef.escola.controller;

import com.unifacef.escola.business.TurmaBusiness;
import com.unifacef.escola.model.Turma;
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
@RequestMapping("/v1/turmas")
public class TurmaController {
    private TurmaBusiness turmaBusiness;

    @Autowired
    public TurmaController(TurmaBusiness turmaBusiness){
        this.turmaBusiness = turmaBusiness;
    }

    @GetMapping
    public List<Turma> findAll(@RequestParam(defaultValue = "0", required = false) Integer numeroPagina){
        Pageable paging = PageRequest.of(numeroPagina, 10);
        Page<Turma> pagedResult = turmaBusiness.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Turma>();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turma>> findbyId(@PathVariable int id){
        turmaBusiness.verificaTurma(id);
        return ResponseEntity.ok().body(turmaBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Turma> post(@RequestBody Turma turma){
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaBusiness.save(turma));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        turmaBusiness.verificaTurma(id);
        turmaBusiness.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Turma> updateTurma(@PathVariable("id") int turmaId, @RequestBody Turma turma){
        turmaBusiness.verificaTurma(turmaId);
        turmaBusiness.updateTurma(turmaId, turma);
        return turmaBusiness.findById(turmaId);
    }

    @GetMapping("/buscaAlunoTurma/{nome}")
    public ResponseEntity<Optional<Turma>> findByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(turmaBusiness.findByAluno_Pessoa_NomeIgnoreCaseContaining(nome));
    }
}
