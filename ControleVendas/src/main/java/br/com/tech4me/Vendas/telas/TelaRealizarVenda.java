package br.com.tech4me.Vendas.telas;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.repository.Repository;

import br.com.tech4me.Vendas.model.Produto;
import br.com.tech4me.Vendas.repositorios.ProdutoRepositorio;



public class TelaRealizarVenda implements Tela<Produto,Integer>{
    
    @Override
    public void executar(Scanner entrada, Repository<Produto, Integer> repositorio) {
        System.out.println("Informe o produto a ser Vendido");
        String busca = entrada.nextLine();

        System.out.println("Informe a quantidade do produto:");
        int  quantidadeVenda = entrada.nextInt();

        System.out.println("Data da Venda:");
        

        ProdutoRepositorio repo = (ProdutoRepositorio) repositorio;
        List<Produto> resultado = repo.findByTituloContainsIgnoreCaseOrderByTituloAsc(busca);

        if(resultado.isEmpty()){

            System.out.println("Não foram encontrados Produtos cadastrados");
            return ;
        
        } 
        

            System.out.println("\n Produto removido com sucesso ");
            System.out.println("-------------------------------------");
    }
    



}
