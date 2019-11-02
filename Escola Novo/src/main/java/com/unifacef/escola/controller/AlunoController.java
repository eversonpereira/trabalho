package com.unifacef.escola.controller;

import com.unifacef.escola.business.AlunoBusiness;
import com.unifacef.escola.model.Aluno;
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
@RequestMapping("/v1/alunos")
public class AlunoController {
    private AlunoBusiness alunoBusiness;

    @Autowired
    public AlunoController(AlunoBusiness alunoBusiness){
        this.alunoBusiness = alunoBusiness;
    }

    @GetMapping
    public List<Aluno> findAll(@RequestParam(defaultValue = "0", required = false) Integer numeroPagina){
        Pageable paging = PageRequest.of(numeroPagina, 10);
        Page<Aluno> pagedResult = alunoBusiness.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Aluno>();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluno>> findBy(@PathVariable int id) {
        alunoBusiness.verificaAluno(id);
        return ResponseEntity.ok().body(alunoBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> post(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoBusiness.save(aluno));
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        alunoBusiness.verificaAluno(id);
        alunoBusiness.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Aluno> updateAluno(@PathVariable("id") int alunoId, @RequestBody Aluno aluno){
        alunoBusiness.verificaAluno(alunoId);
        alunoBusiness.updateAluno(alunoId, aluno);
        return alunoBusiness.findById(alunoId);
    }

    @GetMapping("/buscaNome/{nome}")
    public ResponseEntity<Optional<Aluno>> findByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(alunoBusiness.findByPessoa_NomeIgnoreCaseContaining(nome));
    }


}
