package BoasPraticas;

import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static final GerenciadorDeMensagens gerenciador = new GerenciadorDeMensagens();

    public static void main(String[] args) {
        iniciarMenu();
    }

    private static void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n--- MENU DE AVALIAÇÃO DE TEXTOS ---");
            System.out.println("1 - Adicionar mensagem manualmente");
            System.out.println("2 - Adicionar mensagem automaticamente");
            System.out.println("3 - Listar mensagens cadastradas");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    adicionarManualmente(scanner);
                    break;
                case "2":
                    adicionarAutomaticamente(scanner);
                    break;
                case "3":
                    listar();
                    break;
                case "4":
                    System.out.println("Encerrando o sistema...");
                    rodando = false;
                    break;
                default:
                    System.out.println("Erro: Opção inválida! Escolha um número de 1 a 4.");
            }
        }
        scanner.close();
    }

    private static void adicionarManualmente(Scanner scanner) {
        System.out.print("Digite o texto da mensagem: ");
        String texto = scanner.nextLine();

        System.out.print("Digite a classificação (ou pressione Enter para 'duvidosa'): ");
        String classificacao = scanner.nextLine();

        boolean sucesso = gerenciador.adicionarMensagem(texto, classificacao);
        if (sucesso) {
            System.out.println("Mensagem adicionada com sucesso!");
        } else {
            System.out.println("Erro: O texto da mensagem não pode estar vazio.");
        }
    }

    private static void adicionarAutomaticamente(Scanner scanner) {
        System.out.print("Digite o texto da mensagem: ");
        String texto = scanner.nextLine();

        String classificacaoGerada = AnalisadorDeTextos.avaliar(texto);
        
        boolean sucesso = gerenciador.adicionarMensagem(texto, classificacaoGerada);
        if (sucesso) {
            System.out.println("Mensagem classificada como '" + classificacaoGerada + "' e adicionada com sucesso!");
        } else {
            System.out.println("Erro: O texto da mensagem não pode estar vazio.");
        }
    }

    private static void listar() {
        List<Mensagem> historico = gerenciador.listarMensagens();
        
        if (historico.isEmpty()) {
            System.out.println("Nenhuma mensagem cadastrada no sistema ainda.");
            return;
        }

        System.out.println("\n--- LISTA DE MENSAGENS ---");
        for (Mensagem m : historico) {
            System.out.println("Texto: " + m.getConteudo());
            System.out.println("Classificação: " + m.getClassificacao());
            System.out.println("--------------------------");
        }
    }
}