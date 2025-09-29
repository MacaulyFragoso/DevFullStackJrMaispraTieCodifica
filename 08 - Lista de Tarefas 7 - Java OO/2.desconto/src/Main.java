import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop infinito para permitir o cadastro contínuo de produtos.
        while (true) {
            System.out.println("\n--- Cadastro de Novo Produto ---");

            // --- Etapa 1: Cadastro do Nome ---
            System.out.print("Vendedor, digite o nome do produto: ");
            String nome = scanner.nextLine();

            // Validação simples do nome do produto.
            if (nome == null || nome.trim().isEmpty()) {
                System.out.println("Nome inválido. Reiniciando o cadastro.");
                continue; // Reinicia o loop para um novo cadastro.
            }

            // --- Etapa 2: Cadastro do Preço ---
            double preco = 0;
            while (preco <= 0) {
                try {
                    System.out.print("Digite o preço do produto: R$");
                    preco = Double.parseDouble(scanner.nextLine());
                    if (preco <= 0) {
                        System.out.println("O preço deve ser um valor positivo. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                }
            }

            Produto produto = new Produto(nome, preco);
            double precoOriginal = produto.getPreco();

            // --- Etapa 3: Aplicação do Desconto ---
            boolean descontoValido = false;
            while (!descontoValido) {
                try {
                    System.out.println("\n--- Aplicar Desconto ---");
                    System.out.print("Digite a porcentagem de desconto (entre 0% e 50%): ");
                    // Lê a linha inteira e converte para double.
                    double porcentagem = Double.parseDouble(scanner.nextLine());

                    // Tenta aplicar o desconto.
                    produto.aplicarDesconto(porcentagem);
                    descontoValido = true; // Se não lançar exceção, o desconto é válido.

                    System.out.println("\n--- Compra Realizada com Sucesso! ---");
                    System.out.println("Produto: " + produto.getNome());
                    System.out.println("Preço Original: R$" + String.format("%.2f", precoOriginal));
                    System.out.println("Preço com Desconto: R$" + String.format("%.2f", produto.getPreco()));
                    System.out.println("-----------------------------------------");

                } catch (IllegalArgumentException e) {
                    // Captura o erro se a regra de negócio for violada.
                    System.out.println("Erro: " + e.getMessage() + " Por favor, tente novamente.");
                }
            }
        }
    }
}
