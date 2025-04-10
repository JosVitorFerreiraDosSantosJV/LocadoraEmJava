package JE;

// Importando as bibliotecas necessárias
import java.util.ArrayList;
import java.util.Scanner;

// Classe principal que cuida do sistema
public class SistemaPrincipal {

    // Lista onde a gente vai guardar todos os filmes e jogos cadastrados
    private ArrayList<ItemLocavel> ItemLocavell;

    // Construtor: quando o sistema começa, ele cria a lista
    public SistemaPrincipal() {
        ItemLocavell = new ArrayList<>();

    }

    // Método para adicionar qualquer item (filme ou jogo) na lista
    public void cadastrar(ItemLocavel item) {
        ItemLocavell.add(item); // coloca o item na lista
    }

    // Método que pergunta os dados do filme e cadastra ele
    public void cadastrarFilme() {
        Scanner sc = new Scanner(System.in); // abre o scanner pra ler o teclado

        // Coletando os dados do filme
        System.out.print("Título do filme: ");
        String titulo = sc.nextLine();
        System.out.print("Gênero: ");
        String genero = sc.nextLine();
        System.out.print("Classificação etária: ");
        int classificacao = sc.nextInt();
        System.out.print("Preço base: ");
        double preco = sc.nextDouble();
        System.out.print("Dias alugados: ");
        int dias = sc.nextInt();

        // Cria um novo filme com os dados informados
        Filme filme = new Filme(genero, classificacao, titulo, preco, dias);
        cadastrar(filme); // adiciona na lista
        System.out.println("Filme cadastrado com sucesso!");
    }

    // Método parecido com o de cima, mas agora é pra jogo
    public void cadastrarJogo() {
        Scanner sc = new Scanner(System.in);

        // Pede os dados do jogo
        System.out.print("Título do jogo: ");
        String titulo = sc.nextLine();
        System.out.print("Plataforma: ");
        String plataforma = sc.nextLine();
        System.out.print("É multiplayer? (true/false): ");
        boolean multiplayer = sc.nextBoolean();
        System.out.print("Preço base: ");
        double preco = sc.nextDouble();
        System.out.print("Dias alugados: ");
        int dias = sc.nextInt();

        // Cria um novo jogo e adiciona na lista
        Jogo jogo = new Jogo(plataforma, multiplayer, titulo, preco, dias);
        cadastrar(jogo);
        System.out.println("Jogo cadastrado com sucesso!");
    }

    // Método que mostra todos os títulos dos itens cadastrados
    public void exibirLista() {
        for (ItemLocavel item : ItemLocavell) {
            System.out.println(item.getTitulo()); // imprime só o nome
        }
    }

    // Procura um item na lista pelo título digitado
    public ItemLocavel BuscarPortitulo(String tituloBuscado) {
        for (ItemLocavel item : ItemLocavell) {
            if (item.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                return item; // se achou, retorna ele
            }
        }
        return null; // se não achou, retorna nulo
    }


    // Método que simula o aluguel de um item
    public void simularlocacao() {
        Scanner sl = new Scanner(System.in);
        System.out.print("Digite o título do item para locação: ");
        String titulo = sl.nextLine();
        ItemLocavel item = BuscarPortitulo(titulo); // tenta encontrar o item

        if (item != null) {
            System.out.print("Informe os dias de locação: ");
            int dias = sl.nextInt();
            item.setDiasAlugados(dias); // atualiza os dias de aluguel
            System.out.println("Resumo da locação:");
            item.imprimirResumo(); // mostra o valor total
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    // Método para devolver um item (zera os dias alugados)
    public void devolverItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o título do item a ser devolvido: ");
        String titulo = sc.nextLine();
        ItemLocavel item = BuscarPortitulo(titulo); // procura o item

        if (item != null) {
            item.setDiasAlugados(0); // zera os dias
            System.out.println("Item devolvido com sucesso!");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    // Esse aqui zera todos os dias de todos os itens, como se devolvesse tudo de uma vez
    public void devolverTodos() {
        for (ItemLocavel item : ItemLocavell) {
            item.setDiasAlugados(0); // zera os dias de cada item
        }
        System.out.println("Todos os itens foram devolvidos!");
    }
}
