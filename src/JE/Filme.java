package JE;

// A classe Filme herda de ItemLocavel, ou seja, é um tipo de item que pode ser alugado
public class Filme extends ItemLocavel {

    // Atributos exclusivos do filme
    private String genero;
    private int ClassificacaoEtaria;

    // Construtor: recebe as infos do filme e manda algumas para a superclasse
    public Filme(String genero, int ClassificacaoEtaria, String titulo, double precoBase, int diasAlugados) {
        super(titulo, precoBase, diasAlugados); // chama o construtor da classe mãe
        this.genero = genero;
        this.ClassificacaoEtaria = ClassificacaoEtaria;
    }

    // Esse método calcula quanto vai custar o aluguel do filme no final
    @Override
    public double calcularPrecoFinal() {
        // Começa multiplicando o preço base pelos dias de aluguel
        double ValorTotal = precoBase * diasAlugados;

        // Se o cliente ficou com o filme por mais de 5 dias...
        if (diasAlugados > 5) {
            ValorTotal *= 1.10; // Aplica um grande desconto (provavelmente um erro, explico abaixo)

            // Se a classificação etária for para maiores de 18 anos
            if (ClassificacaoEtaria > 18) {
                ValorTotal *= 1.05; // Aplica um acréscimo de 5% no valor
            }
        }

        return ValorTotal; // Retorna o valor final a ser pago
    }
}
