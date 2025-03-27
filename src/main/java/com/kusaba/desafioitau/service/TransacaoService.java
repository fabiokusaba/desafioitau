package com.kusaba.desafioitau.service;

import com.kusaba.desafioitau.domain.Transacao;
import com.kusaba.desafioitau.dto.TransacaoRequest;
import com.kusaba.desafioitau.service.validation.Validacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// A camada de serviço é a responsável por abrigar a nossa lógica de negócio, portanto não é uma boa prática deixarmos
// tais regras na nossa camada de controller.
// Com a anotação Service indicamos ao Spring que essa classe faz parte do contexto da aplicação, portanto ele irá gerenciar
// a criação de instâncias quando necessário, por exemplo: injeção de dependência no controller.
@Service
public class TransacaoService {

    // Criando uma lista para simular o armazenamento em memória das nossas transações.
    private final List<Transacao> transacoes = new ArrayList<>();

    // Criando uma lista de validações.
    private final List<Validacao> validacoes;

    // Injetando as validações no construtor.
    public TransacaoService(List<Validacao> validacoes) {
        this.validacoes = validacoes;
    }

    public void salvar(TransacaoRequest request) {
        // Validando a nossa request antes de salvá-la em nossa lista, desta forma se alguma validação falhar não
        // iremos prosseguir para a linha de baixo, ou seja, não iremos salvar a transação.
        validacoes.forEach(validacao -> validacao.validar(request));

        // Adicionando uma nova transação na nossa lista.
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
    }

    public void deletar() {
        // Limpando todas as transações da nossa lista.
        validacoes.clear();
    }
}
