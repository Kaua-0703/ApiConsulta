package com.senac.agendamentoconsulta.presentation.controllers;

import com.senac.agendamentoconsulta.application.dtos.ConsultaRequestDTO;
import com.senac.agendamentoconsulta.application.dtos.ConsultaResponseDTO;
import com.senac.agendamentoconsulta.application.services.ConsultaService;
import com.senac.agendamentoconsulta.domain.repositoryes.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> salvarConsulta(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO consultaResponseDTO = consultaService.salvarConsulta(consultaRequestDTO);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarConsultaId(@PathVariable Long id) {
        ConsultaResponseDTO consultaResponseDTO =  consultaService.buscarConsultaId(id);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizarConsulta(@PathVariable Long id,
                                                                 @RequestBody ConsultaRequestDTO consultaRequestDTO){
        ConsultaResponseDTO consultaResponseDTO = consultaService.atualizarConsulta(id, consultaRequestDTO);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> cancelarConsulta(@PathVariable Long id){
        consultaService.cancelarConsulta(id);
        return ResponseEntity.notFound().build();
    }
}