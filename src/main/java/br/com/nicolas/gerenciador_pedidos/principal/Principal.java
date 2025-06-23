package br.com.nicolas.gerenciador_pedidos.principal;

import br.com.nicolas.gerenciador_pedidos.model.Categoria;
import br.com.nicolas.gerenciador_pedidos.model.Fornecedor;
import br.com.nicolas.gerenciador_pedidos.model.Pedido;
import br.com.nicolas.gerenciador_pedidos.model.Produto;
import br.com.nicolas.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.nicolas.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.nicolas.gerenciador_pedidos.repository.PedidoRepository;
import br.com.nicolas.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;

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
        Categoria categoriaEletronicos = new Categoria(null,"Eletrônicos");
        Categoria categoriaRoupas = new Categoria(null,"Roupas");
        Categoria categoriaAlimentos = new Categoria(null,"Alimentos");
        Categoria categoriaAcessorios = new Categoria(null,"Acessórios");
        Categoria categoriaMoveis = new Categoria(null,"Móveis");

        Fornecedor fornecedorKabum = new Fornecedor(null, "Kabum");
        Fornecedor fornecedorMarisa = new Fornecedor(null, "Marisa");
        Fornecedor fornecedorNegreiros = new Fornecedor(null, "Negreiros");
        Fornecedor fornecedorShein = new Fornecedor(null, "Shein");
        Fornecedor fornecedorMadeira = new Fornecedor(null, "Madeira Madeira");

        Produto produto1 = new Produto("Xbox Series X", 6500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Calça Jeans",250.0, categoriaRoupas);
        Produto produto3 = new Produto("Feijão",10.0, categoriaAlimentos);
        Produto produto4 = new Produto("Brincos",25.0, categoriaAcessorios);
        Produto produto5 = new Produto("Mesa",350.0, categoriaMoveis);
        Produto produto6 = new Produto("Lâmpada Inteligente", 150.0, categoriaEletronicos);
        Produto produto7 = new Produto("Blusa",300.0, categoriaRoupas);
        Produto produto8 = new Produto("Arroz",10.0, categoriaAlimentos);
        Produto produto9 = new Produto("Relógio",1200.0, categoriaAcessorios);
        Produto produto10 = new Produto("Sofá",670.0, categoriaMoveis);

        categoriaEletronicos.setProdutos(List.of(produto1, produto6));
        categoriaEletronicos.setProdutos(List.of(produto2, produto7));
        categoriaEletronicos.setProdutos(List.of(produto3, produto8));
        categoriaEletronicos.setProdutos(List.of(produto4, produto9));
        categoriaEletronicos.setProdutos(List.of(produto5, produto10));

        categoriaRepository.saveAll(List.of(categoriaEletronicos,categoriaRoupas,categoriaAcessorios,categoriaAlimentos,categoriaMoveis));

        System.out.println("Categorias e seus produtos:");
        categoriaRepository.findAll().forEach(categoria -> {
            System.out.println("Categoria: " + categoria.getNome());
            categoria.getProdutos().forEach(produto ->
                    System.out.println(" - Produto: " + produto.getNome())
            );
        });

    }
}
