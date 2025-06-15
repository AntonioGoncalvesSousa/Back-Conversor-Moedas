package com.coinchange.coinChange.service;

import com.coinchange.coinChange.domain.dto.historico.HistoricoRequestDTO;
import com.coinchange.coinChange.domain.dto.historico.HistoricoResponseDTO;
import com.coinchange.coinChange.domain.mapper.historico.HistoricoMapper;
import com.coinchange.coinChange.domain.models.Historico;
import com.coinchange.coinChange.domain.models.Usuario;
import com.coinchange.coinChange.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    private UsuarioService usuarioService;

    public void salvar(HistoricoRequestDTO dto, Long idUsuario){
        Historico historico = HistoricoMapper.toEntity(dto);
        Usuario user = usuarioService.getUsuarioById(idUsuario);

        historico.setUsuario(user);
        historico.setDataHora(LocalDateTime.now());

        historicoRepository.save(historico);
    }

    public Page<HistoricoResponseDTO> listarHistoricoPorUsuario(Long idUsuario, int page, int size) {
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);

        Pageable pageable = PageRequest.of(page, size, Sort.by("dataConversao").descending());

        Page<Historico> historicosPage = historicoRepository.findAllByUsuarioOrderByDataHoraDesc(usuario, pageable);

        return historicosPage.map(HistoricoMapper::toResponseDTO);
    }


}
