package com.senac.agendamentoconsulta.application.services;

import com.senac.agendamentoconsulta.application.dtos.ConsultaRequestDTO;
import com.senac.agendamentoconsulta.application.dtos.ConsultaResponseDTO;
import com.senac.agendamentoconsulta.domain.entities.Consulta;
import com.senac.agendamentoconsulta.domain.entities.Status;
import com.senac.agendamentoconsulta.domain.repositoryes.ConsultaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaResponseDTO salvarConsulta( ConsultaRequestDTO consultaRequestDTO) {
        Consulta consulta = new Consulta(consultaRequestDTO);
        consulta.setStatus(Status.AGENDADO);
        consultaRepository.save(consulta);
        return new ConsultaResponseDTO(consulta);
    }

    public ConsultaResponseDTO buscarConsultaId(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        return new ConsultaResponseDTO(consulta);
    }

    public ConsultaResponseDTO atualizarConsulta(Long id, ConsultaRequestDTO consultaRequestDTO){
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(consultaRequestDTO, consulta, "id");
        return new ConsultaResponseDTO(consulta);
    }

    public ConsultaResponseDTO cancelarConsulta(Long id){
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        consulta.setStatus(Status.CANCELADO);
        return new ConsultaResponseDTO(consulta);
    }
}
