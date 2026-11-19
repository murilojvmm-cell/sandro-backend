package com.sandroSite.Sandro.controller; // mantenha o seu package original

import com.sandroSite.Sandro.model.Agendamento;
import com.sandroSite.Sandro.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos") // Se o seu usar "/agendamentos", mantenha igual no React
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @GetMapping
    public List<Agendamento> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        if (agendamento.getStatus() == null || agendamento.getStatus().isEmpty()) {
            agendamento.setStatus("Pendente");
        }
        return repository.save(agendamento);
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Agendamento> concluir(@PathVariable Long id) {
        return repository.findById(id).map(agendamento -> {
            agendamento.setStatus("Concluído");
            return ResponseEntity.ok(repository.save(agendamento));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}