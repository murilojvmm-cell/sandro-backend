package com.sandroSite.Sandro.controller;

import com.sandroSite.Sandro.model.Agendamento;
import com.sandroSite.Sandro.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*") // Permite que o futuro front acesse sem problemas de CORS
public class AgendamentoController {

    private final AgendamentoService service;

    AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    // 1. POST - Criar novo agendamento vindo do site
    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = service.criarAgendamento(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    // 2. GET - Listar todos os chamados para o painel do Sandro
    @GetMapping
    public ResponseEntity<List<Agendamento>> listar() {
        List<Agendamento> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    // 3. PUT - Atualizar o status do atendimento (Ex: mudar para "CONCLUÍDO")
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizarStatus(@PathVariable Long id, @RequestParam String status) throws Throwable {
        Agendamento atualizado = service.atualizarStatus(id, status);
        return ResponseEntity.ok(atualizado);
    }

    // 4. DELETE - Remover um agendamento do sistema
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}