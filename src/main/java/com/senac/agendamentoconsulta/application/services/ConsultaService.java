package com.senac.agendamentoconsulta.application.services;

import com.senac.agendamentoconsulta.application.dtos.ConsultaRequestDTO;
import com.senac.agendamentoconsulta.application.dtos.ConsultaResponseDTO;
import com.senac.agendamentoconsulta.domain.entities.ConsultaMedica;
import com.senac.agendamentoconsulta.domain.entities.Status;
import com.senac.agendamentoconsulta.domain.repositoryes.ConsultaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaResponseDTO salvarConsultaMedica( ConsultaRequestDTO consultaRequestDTO) {
        ConsultaMedica consultaMedica = new ConsultaMedica(consultaRequestDTO);
        consultaMedica.setStatus(Status.AGENDADO);
        consultaRepository.save(consultaMedica);
        return new ConsultaResponseDTO(consultaMedica);
    }

    public ConsultaResponseDTO cancelarConsultaMedica(Long id) {
        ConsultaMedica consultaMedica = consultaRepository.findById(id).orElseThrow();
        consultaMedica.setStatus(Status.CANCELADO);
        return new ConsultaResponseDTO(consultaMedica);
    }

    public ConsultaResponseDTO buscarConsultaMedicaId(Long id) {
        ConsultaMedica consultaMedica = consultaRepository.findById(id).orElseThrow();
        return new ConsultaResponseDTO(consultaMedica);
    }

    public ConsultaResponseDTO atualizarConsultaMedica(Long id, ConsultaRequestDTO consultaRequestDTO){
        ConsultaMedica consultaMedica = consultaRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(consultaRequestDTO, consultaMedica, "id");
        return new ConsultaResponseDTO(consultaMedica);
    }

    public List<ConsultaResponseDTO> buscarTodasConsultasMedicas() {
        List<ConsultaMedica> consultas = consultaRepository.findAll();
        return consultas.stream()
                .map(ConsultaResponseDTO::new)
                .toList();
    }
}
