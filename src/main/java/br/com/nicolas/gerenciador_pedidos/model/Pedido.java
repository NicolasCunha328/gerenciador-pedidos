package br.com.nicolas.gerenciador_pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Pedido {
    @Id
    private final Long id;
    private final LocalDate data;

    public Pedido(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public Long getId() {
        return id;
    }
}
