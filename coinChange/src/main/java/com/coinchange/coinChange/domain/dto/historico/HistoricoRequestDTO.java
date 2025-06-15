package com.coinchange.coinChange.domain.dto.historico;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class HistoricoRequestDTO {
    private String moedaOrigem;
    private String moedaDestino;
    private BigDecimal valorOriginal;
    private BigDecimal valorConvertido;
}
