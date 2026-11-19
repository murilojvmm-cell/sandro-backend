package com.sandroSite.Sandro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String bairro;
    private String aparelho; // Ex: Purificador, Lava e Seca, etc.
    private String descricao;
    private String status; // Ex: "Pendente", "Concluído"
    private LocalDateTime dataCriacao;

    // Construtor Vazio
    public Agendamento() {}

    // Construtor com parâmetros
    public Agendamento(String nome, String telefone, String bairro, String aparelho, String descricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.bairro = bairro;
        this.aparelho = aparelho;
        this.descricao = descricao;
        this.status = "PENDENTE";
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getAparelho() { return aparelho; }
    public void setAparelho(String aparelho) { this.aparelho = aparelho; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}