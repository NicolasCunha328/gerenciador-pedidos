package br.com.nicolas.gerenciador_pedidos.principal;

import br.com.nicolas.gerenciador_pedidos.model.Categoria;
import br.com.nicolas.gerenciador_pedidos.model.Pedido;
import br.com.nicolas.gerenciador_pedidos.model.Produto;
import br.com.nicolas.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.nicolas.gerenciador_pedidos.repository.PedidoRepository;
import br.com.nicolas.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class Principal {

    ProdutoRepository produtoRepository;
    PedidoRepository pedidoRepository;
    CategoriaRepository categoriaRepository;

    public Principal(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository, CategoriaRepository categoriaRepository){
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public void menu(){
        Produto produto = new Produto("Notebook", 3500.0);
        Categoria categoria = new Categoria(1L, "Eletrônicos");
        Pedido pedido = new Pedido(1L, LocalDate.now());

        produtoRepository.save(produto);
        categoriaRepository.save(categoria);
        pedidoRepository.save(pedido);
    }
}
