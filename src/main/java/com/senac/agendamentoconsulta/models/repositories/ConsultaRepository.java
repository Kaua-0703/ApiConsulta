package com.senac.agendamentoconsulta.models.repositories;

import com.senac.agendamentoconsulta.models.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
