package com.coinchange.coinChange.repositories;

import com.coinchange.coinChange.domain.models.Historico;
import com.coinchange.coinChange.domain.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    Page<Historico> findAllByUsuarioOrderByDataHoraDesc(Usuario usuario, Pageable pageable);

}
