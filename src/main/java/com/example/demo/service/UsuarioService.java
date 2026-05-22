package com.example.demo.service;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Usuario procurarPorId(Integer id) {

        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Usuario não encontrado"
            ));
    }

}
