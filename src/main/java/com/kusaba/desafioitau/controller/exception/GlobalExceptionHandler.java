package com.kusaba.desafioitau.controller.exception;

import com.kusaba.desafioitau.dto.ErrorResponse;
import com.kusaba.desafioitau.exception.CampoNaoPreenchidoException;
import com.kusaba.desafioitau.exception.DataHoraFuturaException;
import com.kusaba.desafioitau.exception.ValorNegativoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

// Classe global para tratamento de todas as exceções da minha aplicação.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Atendendo ao requisito proposto no desafio.
    @ExceptionHandler(CampoNaoPreenchidoException.class)
    public ResponseEntity<Void> handleCampoNaoPreenchidoException(CampoNaoPreenchidoException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    // Exemplificando como retornar um objeto no corpo da resposta.
    @ExceptionHandler(ValorNegativoException.class)
    public ResponseEntity<ErrorResponse> handleValorNegativoException(ValorNegativoException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(DataHoraFuturaException.class)
    public ResponseEntity<Void> handleDataHoraFuturaException(DataHoraFuturaException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Void> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
