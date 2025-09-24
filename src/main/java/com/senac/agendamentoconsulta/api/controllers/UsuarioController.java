package com.senac.agendamentoconsulta.api.controllers;

import com.senac.agendamentoconsulta.api.dtos.UsuarioRequestDTO;
import com.senac.agendamentoconsulta.api.dtos.UsuarioResponseDTO;
import com.senac.agendamentoconsulta.models.entities.Usuario;
import com.senac.agendamentoconsulta.models.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public UsuarioResponseDTO salvarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario(usuarioRequestDTO);
        usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscaUsuarioId(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioResponseDTO(usuario);
    }
}