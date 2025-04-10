package JE;

// Classe abstrata base para todos os itens que podem ser alugados (filmes, jogos, etc.)
public abstract class ItemLocavel {

    // Atributos comuns a todos os itens locáveis
    protected String titulo;          // Título do item (ex: nome do filme ou jogo)
    protected double precoBase;       // Preço base de locação por dia
    protected int diasAlugados;       // Quantidade de dias que o item está alugado

    // Construtor da classe base
    public ItemLocavel(String titulo, double precoBase, int diasAlugados){
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.diasAlugados = diasAlugados;
    }

    // Método abstrato para cálculo do preço final da locação.
    // Cada subclasse (Filme, Jogo, etc.) será obrigada a implementar sua própria lógica.
    public abstract double calcularPrecoFinal();

    // Método para exibir um resumo do item alugado, incluindo valor calculado.
    public void imprimirResumo(){
        System.out.println(" Titulo: " + titulo);
        System.out.println(" Dias Alugados: " + diasAlugados);
        System.out.println(" Valor final: " + calcularPrecoFinal());
    }

    // Método getter para acessar o título do item
    public String getTitulo(){
        return titulo;
    }

    // Método setter para atualizar a quantidade de dias alugados
    public void setDiasAlugados(int dias) {
        this.diasAlugados = dias;
    }
}
