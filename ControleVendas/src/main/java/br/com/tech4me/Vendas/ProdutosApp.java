package br.com.tech4me.Vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.tech4me.Vendas.telas.LoopPrincipal;


@SpringBootApplication

public class ProdutosApp implements CommandLineRunner {
	@Autowired
	private LoopPrincipal loopPrincipal;

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loopPrincipal.loop();
		System.exit(0);
	}
}