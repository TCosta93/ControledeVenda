package br.com.tech4me.Vendas.telas;


import java.util.List;
import java.util.Scanner;

import org.springframework.data.repository.Repository;
import br.com.tech4me.Vendas.model.Produto;
import br.com.tech4me.Vendas.repositorios.ProdutoRepositorio;

public class TelaListarProduto implements Tela<Produto,Integer>{

    @Override
    public void executar(Scanner entrada, Repository<Produto, Integer> repositorio) {
       ProdutoRepositorio repo = (ProdutoRepositorio) repositorio;

        List<Produto> produtos = repo.findByOrderByTituloAsc();

        
        if(produtos.isEmpty()){

            System.out.println("Não há Produtos cadastrados");
            return;
        }

        System.out.println("\n Lista de Produtos cadastrados: ");
        produtos.forEach(System.out::println);
        
    }

   
    
}
