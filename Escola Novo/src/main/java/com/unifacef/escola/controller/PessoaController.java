package com.unifacef.escola.controller;

import com.unifacef.escola.business.PessoaBusiness;
import com.unifacef.escola.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Autores:
 * Everson José de Freitas Pereira - Cod: 22304
 * Lucas Rafael Barbosa - Cod: 22314
 */


@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {
    private PessoaBusiness pessoaBusiness;

    @Autowired
    public PessoaController(PessoaBusiness pessoaBusiness){
        this.pessoaBusiness = pessoaBusiness;
    }

    @GetMapping
    public List<Pessoa> findAll(@RequestParam(defaultValue = "0", required = false) Integer numeroPagina){
        Pageable paging = PageRequest.of(numeroPagina, 10);
        Page<Pessoa> pagedResult = pessoaBusiness.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Pessoa>();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findbyId(@PathVariable int id){
       pessoaBusiness.verificaPessoa(id);
       return ResponseEntity.ok().body(pessoaBusiness.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pessoa> post(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaBusiness.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        pessoaBusiness.verificaPessoa(id);
        pessoaBusiness.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Pessoa> updatePessoa(@PathVariable("id") int pessoaId, @RequestBody Pessoa pessoa){
        pessoaBusiness.verificaPessoa(pessoaId);
        pessoaBusiness.updatePessoa(pessoaId, pessoa);
        return pessoaBusiness.findById(pessoaId);
    }

    @GetMapping("/BuscaNome/{nome}")
    public ResponseEntity<Optional<Pessoa>> findByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(pessoaBusiness.findByNomeIgnoreCaseContaining(nome));
    }
}
