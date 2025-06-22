package br.com.nicolas.gerenciador_pedidos.repository;

import br.com.nicolas.gerenciador_pedidos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
