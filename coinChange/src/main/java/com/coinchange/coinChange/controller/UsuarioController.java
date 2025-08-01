package com.coinchange.coinChange.controller;

import com.coinchange.coinChange.domain.dto.usuario.UsuarioRequestDTO;
import com.coinchange.coinChange.domain.dto.usuario.UsuarioResponseDTO;
import com.coinchange.coinChange.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrar(@RequestBody UsuarioRequestDTO dto){
        usuarioService.cadastrarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public UsuarioResponseDTO login(@RequestBody UsuarioRequestDTO dto){
        UsuarioResponseDTO response = usuarioService.login(dto);
        return response;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
