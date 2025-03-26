package com.kusaba.desafioitau.dto;

import java.time.OffsetDateTime;

// Record que representa o payload da nossa requisição de transação.
public record TransacaoRequest(Double valor, OffsetDateTime dataHora) {
}
