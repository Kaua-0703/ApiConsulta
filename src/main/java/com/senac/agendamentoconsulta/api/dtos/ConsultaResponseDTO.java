package com.senac.agendamentoconsulta.api.dtos;

import com.senac.agendamentoconsulta.models.entities.Consulta;
import com.senac.agendamentoconsulta.models.entities.Status;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Long id,
        String nomePaciente,
        String nomeMedico,
        LocalDateTime dataHora,
        Status status) {

    public ConsultaResponseDTO(Consulta consulta) {
        this(consulta.getId(),
             consulta.getNomePaciente(),
             consulta.getNomeMedico(),
             consulta.getDataHora(),
             consulta.getStatus());
    }
}
