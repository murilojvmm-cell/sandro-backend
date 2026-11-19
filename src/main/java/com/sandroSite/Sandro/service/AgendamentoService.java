package com.sandroSite.Sandro.service;

import com.sandroSite.Sandro.model.Agendamento;
import com.sandroSite.Sandro.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    // CREATE (POST)
    public Agendamento criarAgendamento(Agendamento agendamento) {
        agendamento.setStatus("PENDENTE");
        agendamento.setDataCriacao(LocalDateTime.now());
        return (Agendamento) ((org.springframework.data.repository.CrudRepository) repository)
            .save(agendamento);
    }

    // READ (GET - Todos)
    public List<Agendamento> listarTodos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        for (Object agendamento : ((CrudRepository) repository).findAll()) {
            agendamentos.add((Agendamento) agendamento);
        }
        return agendamentos;
    }

    // READ (GET - Por ID)
    @SuppressWarnings("unchecked")
    public Optional<Agendamento> buscarPorId(Long id) {
        return (Optional<Agendamento>) ((CrudRepository) repository).findById(id);
    }

    // UPDATE (PUT)
    public Agendamento atualizarStatus(Long id, String novoStatus) throws Throwable {
        Agendamento agendamento = (Agendamento) ((CrudRepository) repository).findById(id)
            .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));
        agendamento.setStatus(novoStatus);
        return (Agendamento) ((CrudRepository) repository).save(agendamento);
    }

    // DELETE (DELETE)
    public void deletarAgendamento(Long id) {
        repository.deleteById(id);
    }
}