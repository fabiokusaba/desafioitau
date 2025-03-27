package com.kusaba.desafioitau.service.validation.impl;

import com.kusaba.desafioitau.dto.TransacaoRequest;
import com.kusaba.desafioitau.exception.DataHoraFuturaException;
import com.kusaba.desafioitau.service.validation.Validacao;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

// Implementação da validação de data e hora posterior a data e hora atual.
@Component
public class ValidaDataHoraPosteriorImpl implements Validacao {
    @Override
    public void validar(TransacaoRequest request) {
        // Verificando se a data e hora que recebemos na request é posterior a data e hora atual.
        if (request.dataHora().isAfter(OffsetDateTime.now())) {
            throw new DataHoraFuturaException("Data e hora da transação não pode ser posterior a data e hora atual.");
        }
    }
}
