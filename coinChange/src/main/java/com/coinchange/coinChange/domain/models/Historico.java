package com.coinchange.coinChange.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico")
@Getter
@Setter
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "moeda_origem", nullable = false)
    private String moedaOrigem;

    @Column(name = "moeda_destino", nullable = false)
    private String moedaDestino;

    @Column(name = "valor_original", nullable = false, precision = 19, scale = 4)
    private BigDecimal valorOriginal;

    @Column(name = "valor_convertido", nullable = false, precision = 19, scale = 4)
    private BigDecimal valorConvetrido;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
}
