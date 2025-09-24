package com.senac.agendamentoconsulta.api.dtos;

import com.senac.agendamentoconsulta.models.entities.Usuario;

public record UsuarioResponseDTO(Long id,
                                 String nome,
                                 String email) {

    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),
             usuario.getNome(),
             usuario.getEmail());
    }
}
