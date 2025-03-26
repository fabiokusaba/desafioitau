package com.kusaba.desafioitau.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

// Estamos trabalhando com o domínio da nossa aplicação, portanto aqui representamos Transacao como uma classe e não
// como um record, pois futuramente caso essa classe seja gerenciada pelo JPA, por exemplo, é mais comum trabalharmos
// com classes.
// Como adicionamos o Lombok ao projeto podemos usar as suas anotações para a construção da nossa classe.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    private Double valor;
    private OffsetDateTime dataHora;
}
