package br.com.nicolas.gerenciador_pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    @Id
    private final Long id;
    private final String nome;

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
