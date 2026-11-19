package com.sandroSite.Sandro.repository;

import com.sandroSite.Sandro.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    // O JpaRepository já nos dá o CRUD completo pronto
}