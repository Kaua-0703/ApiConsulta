package com.senac.agendamentoconsulta.application.dtos;

import com.senac.agendamentoconsulta.domain.entities.ConsultaMedica;
import com.senac.agendamentoconsulta.domain.entities.Status;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Long id,
        String nomePaciente,
        String nomeMedico,
        LocalDateTime dataHora,
        Status status) {

    public ConsultaResponseDTO(ConsultaMedica consulta) {
        this(consulta.getId(),
             consulta.getNomePaciente(),
             consulta.getNomeMedico(),
             consulta.getDataHora(),
             consulta.getStatus());
    }
}
