package com.senac.agendamentoconsulta.application.dtos;

import com.senac.agendamentoconsulta.domain.entities.Usuario;

public record UsuarioResponseDTO(Long id,
                                 String nome,
                                 String email) {

    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),
             usuario.getNome(),
             usuario.getEmail());
    }
}
