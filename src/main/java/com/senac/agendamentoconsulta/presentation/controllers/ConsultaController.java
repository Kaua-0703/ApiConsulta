package com.senac.agendamentoconsulta.presentation.controllers;

import com.senac.agendamentoconsulta.application.dtos.ConsultaRequestDTO;
import com.senac.agendamentoconsulta.application.dtos.ConsultaResponseDTO;
import com.senac.agendamentoconsulta.application.services.ConsultaService;
import com.senac.agendamentoconsulta.domain.entities.ConsultaMedica;
import com.senac.agendamentoconsulta.domain.repositoryes.ConsultaRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Operation(summary = "Autenticação de consulta", description = "Método para salvar uma consulta!!")
    public ResponseEntity<ConsultaResponseDTO> salvarConsulta(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO consultaResponseDTO = consultaService.salvarConsultaMedica(consultaRequestDTO);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca consulta por id", description = "Método para encontrar uma consulta por id!!")
    public ResponseEntity<ConsultaResponseDTO> buscarConsultaId(@PathVariable Long id) {
        ConsultaResponseDTO consultaResponseDTO = consultaService.buscarConsultaMedicaId(id);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar consulta", description = "Método para atualizar e modificar a consulta!!")
    public ResponseEntity<ConsultaResponseDTO> atualizarConsulta(@PathVariable Long id,
                                                                 @RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO consultaResponseDTO = consultaService.atualizarConsultaMedica(id, consultaRequestDTO);
        return ResponseEntity.ok(consultaResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar consulta", description = "Método para cancelar/deletar uma consulta!!!")
    public ResponseEntity<?> cancelarConsulta(@PathVariable Long id) {
        consultaService.cancelarConsultaMedica(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Buscar todas consultas", description = "Método para buscar todas as consultas!!!")
    public ResponseEntity<List<ConsultaResponseDTO>> buscarTodasConsultasMedicas() {
        List<ConsultaResponseDTO> consultasMedicas = consultaService.buscarTodasConsultasMedicas();
        return ResponseEntity.ok(consultasMedicas);
    }
}