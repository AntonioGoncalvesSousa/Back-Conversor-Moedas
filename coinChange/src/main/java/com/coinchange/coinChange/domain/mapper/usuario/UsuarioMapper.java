package com.coinchange.coinChange.domain.mapper.usuario;

import com.coinchange.coinChange.domain.dto.usuario.UsuarioRequestDTO;
import com.coinchange.coinChange.domain.dto.usuario.UsuarioResponseDTO;
import com.coinchange.coinChange.domain.models.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario){
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNomeUsuario());
    }
}
