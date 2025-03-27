package com.kusaba.desafioitau.controller;

import com.kusaba.desafioitau.dto.TransacaoRequest;
import com.kusaba.desafioitau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Através da anotação RestController estamos indicando que essa classe faz parte do contexto do Spring, desta forma
// ele entende que essa classe é um controlador, local onde requisições HTTP serão feitas para os recursos da aplicação.
// Com a anotação RequestMapping definimos que dentro desse recurso/classe vamos operar com esse prefixo de URL.
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    // Injetando o nosso service no controller através do construtor.
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    // Operação de inserção -> toda vez que realizamos operações de inserção de dados o verbo HTTP mais indicado é o POST.
    // A anotação RequestBody indica que o que estamos recebendo virá no corpo da requisição.
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody TransacaoRequest request) {
        transacaoService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Operação de deleção -> toda vez que realizamos operações de deleção de dados o verbo HTTP mais indicado é o DELETE.
    @DeleteMapping
    public ResponseEntity<Void> deletar() {
        transacaoService.deletar();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
