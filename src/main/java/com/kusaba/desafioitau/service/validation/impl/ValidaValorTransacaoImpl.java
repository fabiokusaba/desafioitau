package com.kusaba.desafioitau.service.validation.impl;

import com.kusaba.desafioitau.dto.TransacaoRequest;
import com.kusaba.desafioitau.exception.ValorNegativoException;
import com.kusaba.desafioitau.service.validation.Validacao;
import org.springframework.stereotype.Component;

// Implementação da validação de valor negativo da transação.
@Component
public class ValidaValorTransacaoImpl implements Validacao {
    @Override
    public void validar(TransacaoRequest request) {
        if (request.valor() < 0) {
            throw new ValorNegativoException("A transação não pode ter valor negativo.");
        }
    }
}
