package com.senac.agendamentoconsulta.domain.entities;

import com.senac.agendamentoconsulta.application.dtos.ConsultaRequestDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ConsultaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePaciente;
    private String nomeMedico;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private Status status;

    public ConsultaMedica() {
    }

    public ConsultaMedica(Long id, String nomePaciente, String nomeMedico, LocalDateTime dataHora, Status status) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.dataHora = dataHora;
        this.status = status;
    }

    public ConsultaMedica(ConsultaRequestDTO consultaRequestDTO){
        this.nomePaciente = consultaRequestDTO.nomePaciente();
        this.nomeMedico = consultaRequestDTO.nomeMedico();
        this.dataHora = consultaRequestDTO.dataHora();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
