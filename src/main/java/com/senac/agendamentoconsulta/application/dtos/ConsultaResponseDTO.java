package com.senac.agendamentoconsulta.application.dtos;

import com.senac.agendamentoconsulta.domain.entities.Consulta;
import com.senac.agendamentoconsulta.domain.entities.Status;

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
