package com.senac.agendamentoconsulta.presentation.controllers;

import com.senac.agendamentoconsulta.application.dtos.UsuarioRequestDTO;
import com.senac.agendamentoconsulta.application.dtos.UsuarioResponseDTO;
import com.senac.agendamentoconsulta.domain.entities.Usuario;
import com.senac.agendamentoconsulta.domain.repositoryes.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuario por id", description = "Método para buscar usuario por id!!!")
    public UsuarioResponseDTO buscaUsuarioId(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioResponseDTO(usuario);
    }

    @PostMapping
    @Operation(summary = "Salvar usuario", description = "Método para salvar usuario!!!")
    public UsuarioResponseDTO salvarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario(usuarioRequestDTO);
        usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }
}