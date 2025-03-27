package com.kusaba.desafioitau.service.validation.impl;

import com.kusaba.desafioitau.dto.TransacaoRequest;
import com.kusaba.desafioitau.exception.CampoNaoPreenchidoException;
import com.kusaba.desafioitau.service.validation.Validacao;
import org.springframework.stereotype.Component;

// Implementação da validação de campos preenchidos.
// Com a anotação Component indicamos ao Spring que essa classe será um componente gerenciado por ele.
@Component
public class ValidaCamposPreenchidosImpl implements Validacao {
    @Override
    public void validar(TransacaoRequest request) {
        // Se o valor ou a dataHora vindos da request forem nulos, lançamos uma exceção.
        if (request.valor() == null || request.dataHora() == null) {
            throw new CampoNaoPreenchidoException("Campo valor ou dataHora não foram preenchidos.");
        }
    }
}
