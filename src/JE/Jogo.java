package JE;

// A classe Jogo é um tipo de item locável, por isso herda de ItemLocavel
public class Jogo extends ItemLocavel {

    // Atributos próprios do jogo
    private String plataforma;
    private boolean multiplayer;

    // Construtor que recebe as infos do jogo e repassa as comuns para a superclasse
    public Jogo(String plataforma, boolean multiplayer, String titulo, double precoBase, int diasAlugados) {
        super(titulo, precoBase, diasAlugados); // chama o construtor da classe mãe
        this.plataforma = plataforma;
        this.multiplayer = multiplayer;
    }

    // Método que calcula o valor final do aluguel do jogo
    @Override
    public double calcularPrecoFinal() {
        double ValorTotal = precoBase * diasAlugados; // cálculo básico: preço base vezes dias alugados

        // Se o jogo for multiplayer...
        if (multiplayer) {
            ValorTotal *= 1.5; // aplica um acréscimo de 50% no valor

            // ...e se o jogo foi alugado por menos de 3 dias
            if (diasAlugados < 3) {
                ValorTotal *= 0.90; // aplica um desconto de 90% (provavelmente um erro)
            }
        }

        return ValorTotal; // retorna o valor final
    }
}
