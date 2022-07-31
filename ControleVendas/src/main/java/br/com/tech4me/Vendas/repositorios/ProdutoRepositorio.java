package br.com.tech4me.Vendas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tech4me.Vendas.model.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer>{
    

    List<Produto> findByOrderByTituloAsc();
    List<Produto> findByTituloContainsIgnoreCaseOrderByTituloAsc(String titulo);
 }