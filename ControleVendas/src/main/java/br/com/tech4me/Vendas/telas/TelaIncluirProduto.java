package br.com.tech4me.Vendas.telas;


import java.util.Scanner;

import org.springframework.data.repository.Repository;

import br.com.tech4me.Vendas.model.Produto;
import br.com.tech4me.Vendas.repositorios.ProdutoRepositorio;

public class TelaIncluirProduto implements Tela<Produto,Integer> {

    @Override
    public void executar(Scanner entrada, Repository<Produto, Integer> repositorio) {

        Produto f = new Produto();
        
        System.out.println("Nome: ");
        f.setNome(entrada.nextLine());

        System.out.println("Preço: ");
        f.setPreco(entrada.nextDouble());
        
        entrada.nextLine();// ignora enter

        ProdutoRepositorio repo = (ProdutoRepositorio) repositorio;

        repo.save(f);
        System.out.println("Produto Cadastrado com sucesso !");
    
    }

    


}
