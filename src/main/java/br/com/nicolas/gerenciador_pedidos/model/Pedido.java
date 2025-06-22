package br.com.nicolas.gerenciador_pedidos.model;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class Pedido {
    @Id
    private final Long id;
    private final LocalDate data;

    public Pedido(LocalDate data, Long id) {
        this.data = data;
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public Long getId() {
        return id;
    }
}
