package com.kusaba.desafioitau.service;

import com.kusaba.desafioitau.domain.Transacao;
import com.kusaba.desafioitau.dto.EstatisticaResponse;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class EstatisticaService {

    // Precisamos injetar o serviço de transação para obtermos a lista de transações.
    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public EstatisticaResponse obterMetricas() {
        // Precisamos pegar todas as transações, filtrar as que ocorreram nos últimos 60 segundos e obter as
        // informações que precisamos retornar.
        var transacoes = transacaoService.getTransacoes();

        var ultimos60Segundos = OffsetDateTime.now().minusSeconds(60);

        var transacoesFiltradas = transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(ultimos60Segundos))
                .toList();

        var estatisticas = transacoesFiltradas.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        // Se não houver transações, retornamos 0.0 para min e max.
        Double min = estatisticas.getCount() > 0 ? estatisticas.getMin() : 0.0;
        Double max = estatisticas.getCount() > 0 ? estatisticas.getMax() : 0.0;

        return new EstatisticaResponse(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                max,
                min
        );
    }
}
