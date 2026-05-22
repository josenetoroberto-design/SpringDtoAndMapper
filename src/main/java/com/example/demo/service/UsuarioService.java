package com.example.demo.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){

        usuario.setDataCriado(Instant.now());

        return usuarioRepository.save(usuario);
    }

    public List <Usuario> listarTodos() {
        
        return usuarioRepository.findAll();
    }

}
