public class Produto {

    private String nome;
    private double preco;

    // Construtor para inicializar o objeto Produto.
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos para obter os valores dos atributos (Getters).
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void aplicarDesconto(double porcentagem) {
        // Valida a regra de negócio: desconto deve ser entre 0 e 50.
        if (porcentagem < 0 || porcentagem > 50) {
            throw new IllegalArgumentException("A porcentagem de desconto deve estar entre 0% e 50%.");
        }

        // Calcula e aplica o desconto.
        double valorDoDesconto = this.preco * (porcentagem / 100);
        this.preco = this.preco - valorDoDesconto;
    }
}
