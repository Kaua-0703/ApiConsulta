package com.senac.agendamentoconsulta.api.controllers;

import com.senac.agendamentoconsulta.api.dtos.ConsultaRequestDTO;
import com.senac.agendamentoconsulta.api.dtos.ConsultaResponseDTO;
import com.senac.agendamentoconsulta.models.entities.Consulta;
import com.senac.agendamentoconsulta.models.entities.Status;
import com.senac.agendamentoconsulta.models.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public ConsultaResponseDTO salvarConsulta(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        Consulta consulta = new Consulta(consultaRequestDTO);
        consulta.setStatus(Status.AGENDADO);
        consultaRepository.save(consulta);
        return new ConsultaResponseDTO(consulta);
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO buscarConsultaId(@PathVariable Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        return new ConsultaResponseDTO(consulta);
    }

    @PutMapping("/{id}")
    public ConsultaResponseDTO atualizarConsulta(@PathVariable Long id){
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        return new ConsultaResponseDTO(consulta);
    }

    @DeleteMapping ("/{id}")
    public ConsultaResponseDTO deletarConsulta(@PathVariable Long id){
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        return new ConsultaResponseDTO(consulta);
    }
}