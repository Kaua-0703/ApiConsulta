package com.senac.agendamentoconsulta.application.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequestDTO(
        @NotBlank(message = "O nome do paciente não deve ser vazio!!") String nomePaciente,
        @NotBlank(message = "O nome do médico não deve ser vazio!!") String nomeMedico,
        @NotNull(message = "A data e hora não pode ser deixada em branco!!")
        @FutureOrPresent(message = "Sua consulta não pode ser agendada no passado!!")
        LocalDateTime dataHora) {
}
