package br.com.nicolas.gerenciador_pedidos.repository;

import br.com.nicolas.gerenciador_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
