package br.com.tech4me.Vendas.telas;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import br.com.tech4me.Vendas.repositorios.ProdutoRepositorio;


@Component
public class LoopPrincipal {
    @Autowired
    private ApplicationContext context;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void loop() {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do {
            Tela tela = null;
            Repository repositorio = null;
            limparTela();
            
            System.out.println("**************");
            System.out.println("MENU PRINCIPAL");
            System.out.println("**************");
            System.out.println("Selecione a opção  desejada:");
            System.out.println(" ");
            System.out.println("1 - Buscar Produto");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Listar Produto");
            System.out.println("4 - Deletar Produto");
            System.out.println("5 - Realizar Venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();// Limpa o ENTER

            switch (opcao) {
                case 1:
                 tela = new TelaBuscarProduto();
                 repositorio=context.getBean(ProdutoRepositorio.class);
                    break;
                case 2:
                tela = new TelaIncluirProduto();
                repositorio=context.getBean(ProdutoRepositorio.class);
                    break;
                case 3:
                tela = new TelaListarProduto();
                repositorio=context.getBean(ProdutoRepositorio.class);
                break;

                case 4:
                tela = new TelaDeletarProduto();
                repositorio=context.getBean(ProdutoRepositorio.class);
                break;

                case 5:
             //   tela = new TelaRealizarVenda();
                repositorio=context.getBean(ProdutoRepositorio.class);

                break;

                case 0:
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    voltarMenu(entrada);
                    break;
            }

            if(tela != null) {
                limparTela();
                tela.executar(entrada, repositorio);
                voltarMenu(entrada);
            }
        } while(opcao != 0);

        entrada.close();
    }

    public static void limparTela() {
        try {
            // Limpa toda a tela do console
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
        } catch(Exception e) {}
    }

    private void voltarMenu(Scanner entrada) {
        System.out.print("\nPressione ENTER para continuar...");
        entrada.nextLine();

        limparTela();
        System.out.flush();
    }
}