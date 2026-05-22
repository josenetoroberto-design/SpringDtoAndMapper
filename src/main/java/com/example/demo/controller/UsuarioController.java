package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CriarUsuarioDto;
import com.example.demo.dto.UsuarioDto;
import com.example.demo.entity.Usuario;
import com.example.demo.mapper.UsuarioMapper;
import com.example.demo.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping (path= "/senhadto")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity <UsuarioDto> criarUsuario(
        @RequestBody CriarUsuarioDto criarUsuarioDto  // O usuario vai mandar.
    ) {

        Usuario usuario = usuarioMapper.dtoParaEntity(criarUsuarioDto);

        Usuario usuarioCriado = usuarioService.criarUsuario(usuario);

        UsuarioDto usuarioDto = usuarioMapper.entityParaDto(usuarioCriado);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);

    }

    @GetMapping("/todos")
    public ResponseEntity <List<UsuarioDto>> listarTodos() {

        List <Usuario> usuarios = usuarioService.listarTodos();

        List<UsuarioDto> resposta = usuarios.stream()
            .map(usuarioMapper::entityParaDto)
            .toList();

        return ResponseEntity.ok(resposta);

    }

    @GetMapping()
    public ResponseEntity <UsuarioDto> procurarPorId(@RequestParam Integer id) {

        Usuario usuario = usuarioService.procurarPorId(id);

        UsuarioDto usuarioEncontrado = usuarioMapper.entityParaDto(usuario);

        return ResponseEntity.ok(usuarioEncontrado);
    }

    @PutMapping()
    public ResponseEntity <UsuarioDto> atualizarUsuario(@RequestParam Integer id , 
                                                        @RequestBody CriarUsuarioDto criarUsuarioDto) {

        Usuario usuario = usuarioMapper.dtoParaEntity(criarUsuarioDto);

        Usuario usuarioCriado = usuarioService.atualizarUsuario(id ,usuario);

        UsuarioDto usuarioDto = usuarioMapper.entityParaDto(usuarioCriado);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioDto);

    }
}
