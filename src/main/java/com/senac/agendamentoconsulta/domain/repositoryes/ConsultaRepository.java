package com.senac.agendamentoconsulta.domain.repositoryes;

import com.senac.agendamentoconsulta.domain.entities.ConsultaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaMedica, Long> {
}
