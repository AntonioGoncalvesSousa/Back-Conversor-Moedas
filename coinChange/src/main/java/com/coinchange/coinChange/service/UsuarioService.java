package com.coinchange.coinChange.service;

import com.coinchange.coinChange.domain.dto.usuario.UsuarioRequestDTO;
import com.coinchange.coinChange.domain.dto.usuario.UsuarioResponseDTO;
import com.coinchange.coinChange.domain.mapper.usuario.UsuarioMapper;
import com.coinchange.coinChange.domain.models.Usuario;
import com.coinchange.coinChange.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(UsuarioRequestDTO dto){
        Usuario user = UsuarioMapper.toEntity(dto);
        usuarioRepository.save(user);
    }

    public UsuarioResponseDTO login(UsuarioRequestDTO dto){
        Optional<Usuario> user = usuarioRepository.findByNomeUsuario(dto.getNomeUsuario());

        Usuario usuario = user.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenha().equals(dto.getSenha())){
            throw new RuntimeException("Senha Incorreta");
        }

        return UsuarioMapper.toResponseDTO(usuario);
    }

    public Usuario getUsuarioById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}
