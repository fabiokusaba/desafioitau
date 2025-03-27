package com.kusaba.desafioitau.service.validation;

import com.kusaba.desafioitau.dto.TransacaoRequest;

// Interface que define o contrato para as validações de transação.
public interface Validacao {
    void validar(TransacaoRequest request);
}
