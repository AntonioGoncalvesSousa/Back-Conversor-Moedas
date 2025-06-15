package com.coinchange.coinChange.domain.mapper.historico;

import com.coinchange.coinChange.domain.dto.historico.HistoricoRequestDTO;
import com.coinchange.coinChange.domain.dto.historico.HistoricoResponseDTO;
import com.coinchange.coinChange.domain.models.Historico;

public class HistoricoMapper {

    public static Historico toEntity(HistoricoRequestDTO dto){
        Historico model = new Historico();
        model.setMoedaDestino(dto.getMoedaDestino());
        model.setMoedaOrigem(dto.getMoedaOrigem());
        model.setValorConvetrido(dto.getValorConvertido());
        model.setValorOriginal(dto.getValorOriginal());
        return model;
    }

    public static HistoricoResponseDTO toResponseDTO(Historico entity){
        HistoricoResponseDTO dto = new HistoricoResponseDTO();
        dto.setMoedaDestino(entity.getMoedaDestino());
        dto.setMoedaOrigem(entity.getMoedaOrigem());
        dto.setValorOriginal(entity.getValorOriginal());
        dto.setValorConvertido(entity.getValorConvetrido());
        dto.setDataConversao(entity.getDataHora());

        return dto;
    }
}
