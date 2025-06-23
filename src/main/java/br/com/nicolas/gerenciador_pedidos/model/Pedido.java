package br.com.nicolas.gerenciador_pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
    @Id
    private Long id;
    private LocalDate data;
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    public Pedido(){}

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
