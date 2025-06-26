package br.com.nicolas.gerenciador_pedidos.principal;

import br.com.nicolas.gerenciador_pedidos.model.Categoria;
import br.com.nicolas.gerenciador_pedidos.model.Fornecedor;
import br.com.nicolas.gerenciador_pedidos.model.Pedido;
import br.com.nicolas.gerenciador_pedidos.model.Produto;
import br.com.nicolas.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.nicolas.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.nicolas.gerenciador_pedidos.repository.PedidoRepository;
import br.com.nicolas.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class Principal {

    ProdutoRepository produtoRepository;
    PedidoRepository pedidoRepository;
    CategoriaRepository categoriaRepository;
    FornecedorRepository fornecedorRepository;

    public Principal(ProdutoRepository produtoRepository, PedidoRepository pedidoRepository, CategoriaRepository categoriaRepository, FornecedorRepository fornecedorRepository){
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
        this.categoriaRepository = categoriaRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public void menu(){
        // criando categorias
        Categoria categoriaEletronicos = new Categoria("Eletrônicos");
        Categoria categoriaRoupas = new Categoria("Roupas");
        Categoria categoriaAlimentos = new Categoria("Alimentos");
        Categoria categoriaAcessorios = new Categoria("Acessórios");
        Categoria categoriaMoveis = new Categoria("Móveis");

        // criando fornecedores
        Fornecedor fornecedorKabum = new Fornecedor("Kabum");
        Fornecedor fornecedorMarisa = new Fornecedor("Marisa");
        Fornecedor fornecedorNegreiros = new Fornecedor("Negreiros");
        Fornecedor fornecedorShein = new Fornecedor("Shein");
        Fornecedor fornecedorMadeira = new Fornecedor("Madeira Madeira");

        // criando produtos
        Produto produto1 = new Produto("Xbox Series X", 6500.0, categoriaEletronicos, fornecedorKabum);
        Produto produto2 = new Produto("Calça Jeans",250.0, categoriaRoupas, fornecedorMarisa);
        Produto produto3 = new Produto("Feijão",10.0, categoriaAlimentos, fornecedorNegreiros);
        Produto produto4 = new Produto("Brincos",25.0, categoriaAcessorios, fornecedorShein);
        Produto produto5 = new Produto("Mesa",350.0, categoriaMoveis, fornecedorMadeira);

        Produto produto6 = new Produto("Lâmpada Inteligente", 150.0, categoriaEletronicos, fornecedorKabum);
        Produto produto7 = new Produto("Blusa",300.0, categoriaRoupas, fornecedorMarisa);
        Produto produto8 = new Produto("Arroz",10.0, categoriaAlimentos, fornecedorNegreiros);
        Produto produto9 = new Produto("Relógio",1200.0, categoriaAcessorios, fornecedorShein);
        Produto produto10 = new Produto("Sofá",670.0, categoriaMoveis, fornecedorMadeira);

        categoriaRepository.saveAll(List.of(categoriaEletronicos,categoriaRoupas,categoriaAcessorios,categoriaAlimentos,categoriaMoveis));
        fornecedorRepository.saveAll(List.of(fornecedorKabum,fornecedorMarisa,fornecedorNegreiros,fornecedorShein,fornecedorMadeira));
        produtoRepository.saveAll(List.of(produto1,produto2,produto3,produto4,produto5,produto6,produto7,produto8,produto9,produto10));

        //criando pedidos e associando produtos
        Pedido pedido1 = new Pedido(LocalDate.now());
        pedido1.setProdutos(List.of(produto1, produto3, produto5, produto7, produto9));
        Pedido pedido2 = new Pedido(LocalDate.now());
        pedido2.setProdutos(List.of(produto2, produto4, produto6, produto8, produto10));
        pedidoRepository.saveAll(List.of(pedido1, pedido2));

        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(1L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );

        System.out.println("\nPedidos e seus produtos:");
        pedidoRepository.findAll().forEach(pedido -> {
            System.out.println("Pedido " + pedido.getId() + ":");
            pedido.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });

        System.out.println("\nProdutos e seus fornecedores:");
        produtoRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }
}
