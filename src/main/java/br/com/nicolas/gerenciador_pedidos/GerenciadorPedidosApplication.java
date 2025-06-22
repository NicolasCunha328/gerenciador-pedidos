package br.com.nicolas.gerenciador_pedidos;

import br.com.nicolas.gerenciador_pedidos.principal.Principal;
import br.com.nicolas.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.nicolas.gerenciador_pedidos.repository.PedidoRepository;
import br.com.nicolas.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(produtoRepository, pedidoRepository, categoriaRepository);
		principal.menu();
	}
}
