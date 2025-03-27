package com.kusaba.desafioitau.controller;

import com.kusaba.desafioitau.dto.EstatisticaResponse;
import com.kusaba.desafioitau.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponse> obterMetricas() {
        var estatistica = estatisticaService.obterMetricas();
        return ResponseEntity.ok(estatistica);
    }
}
