package br.com.nicolas.gerenciador_pedidos.repository;

import br.com.nicolas.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
