package com.coinchange.coinChange.domain.dto.historico;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class HistoricoResponseDTO {
    private String moedaOrigem;
    private String moedaDestino;
    private BigDecimal valorOriginal;
    private BigDecimal valorConvertido;
    private LocalDateTime dataConversao;

}
