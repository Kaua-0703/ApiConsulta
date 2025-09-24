package com.senac.agendamentoconsulta.api.dtos;

import java.time.LocalDateTime;

public record ConsultaRequestDTO(
        String nomePaciente,
        String nomeMedico,
        LocalDateTime dataHora) {
}
