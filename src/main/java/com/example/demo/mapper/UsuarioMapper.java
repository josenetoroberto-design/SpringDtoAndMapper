package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CriarUsuarioDto;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.entity.Usuario;

@Component
public class UsuarioMapper {

    public Usuario dtoParaEntity(CriarUsuarioDto criarUsuarioDto) {

        Usuario usuario = new Usuario();

        usuario.setNome(criarUsuarioDto.nome());
        usuario.setEmail(criarUsuarioDto.email());
        usuario.setSenha(criarUsuarioDto.senha());

        return usuario;
    }

    public UsuarioDto entityParaDto(Usuario usuario) {

        UsuarioDto usuarioDto = new UsuarioDto(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail()

        );

        return usuarioDto;
    }

}
