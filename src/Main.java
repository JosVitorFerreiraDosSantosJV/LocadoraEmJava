import JE.SistemaPrincipal; // Importa a classe responsável por gerenciar os itens

import java.util.Scanner; // Importa o Scanner para ler a entrada do usuário

public class Main {
    public static void main(String[] args) {
        SistemaPrincipal sistema = new SistemaPrincipal(); // Cria o sistema de locação
        Scanner scanner = new Scanner(System.in); // Scanner para ler o que o usuário digita
        int opcao; // Variável para armazenar a opção escolhida no menu

        // Menu principal que repete até o usuário escolher sair (opção 0)
        do {
            // Exibe o menu na tela com emojis pra deixar mais divertido
            System.out.println("\n🎬🎮📚==============================📚🎮🎬");
            System.out.println("     SISTEMA DE LOCAÇÃO DE ITENS");
            System.out.println("📚🎮🎬==============================🎬🎮📚");
            System.out.println("1️⃣  Cadastrar Filme");
            System.out.println("2️⃣  Cadastrar Jogo");
            System.out.println("3️⃣  Exibir Catálogo");
            System.out.println("4️⃣  Simular Locação");
            System.out.println("5️⃣  Devolver Item");
            System.out.println("6️⃣  Devolver Todos os Itens");
            System.out.println("0️⃣  Sair");
            System.out.print("👉 Escolha uma opção: ");
            opcao = scanner.nextInt(); // Lê a opção digitada
            scanner.nextLine(); // Limpa o buffer (evita bugs com nextLine depois de nextInt)

            // Verifica qual opção o usuário escolheu
            switch (opcao) {
                case 1:
                    System.out.println("\n🎬 Cadastro de Filme");
                    sistema.cadastrarFilme(); // Chama o método para cadastrar um filme
                    break;
                case 2:
                    System.out.println("\n🎮 Cadastro de Jogo");
                    sistema.cadastrarJogo(); // Chama o método para cadastrar um jogo
                    break;
                case 3:
                    System.out.println("\n📚 Itens Cadastrados:");
                    sistema.exibirLista(); // Mostra todos os itens cadastrados
                    break;
                case 4:
                    System.out.println("\n💡 Simulação de Locação");
                    sistema.simularlocacao(); // Simula a locação de um item
                    break;
                case 5:
                    System.out.println("\n🔁 Devolver Item");
                    sistema.devolverItem(); // Permite devolver um item específico
                    break;
                case 6:
                    System.out.println("\n🧹 Devolução em Massa");
                    sistema.devolverTodos(); // Devolve todos os itens de uma vez
                    break;
                case 0:
                    System.out.println("\n👋 Até logo, obrigado por usar o sistema!");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente."); // Caso o número não esteja entre 0 e 6
            }

        } while (opcao != 0); // Continua rodando o menu até o usuário digitar 0 (sair)
    }
}
