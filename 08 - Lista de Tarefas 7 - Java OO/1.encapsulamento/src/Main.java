import java.util.InputMismatchException;
import java.util.Scanner;

// Classe principal para demonstrar o uso interativo da classe Produto.
public class Main {
    public static void main(String[] args) {
        // Try-with-resources para garantir que o scanner seja fechado.
        try (Scanner scanner = new Scanner(System.in)) {
            // Loop infinito para permitir múltiplos cadastros.
            while (true) {
                System.out.println("--- Cadastro de Novo Produto ---");
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();

                // Validação imediata do nome.
                if (nome == null || nome.trim().isEmpty()) {
                    System.out.println("\nERRO NO CADASTRO: O nome não pode ser nulo ou vazio.");
                } else {
                    // Se o nome for válido, continua para preço e quantidade.
                    double preco = obterPrecoValido(scanner);
                    int quantidade = obterQuantidadeValida(scanner);

                    Produto produto = new Produto(nome, preco, quantidade);
                    System.out.println("\n-> Produto cadastrado com sucesso!");
                    exibirProduto(produto);
                }

                System.out.println("\n=====================================");
                System.out.println("Iniciando um novo cadastro de produto");
                System.out.println("=====================================\n");
            }
        }
    }

    // Método para obter um preço válido do usuário.
    private static double obterPrecoValido(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                if (preco < 0) {
                    System.out.println("ERRO: O preço não pode ser negativo. Tente novamente.");
                } else {
                    return preco;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO DE ENTRADA: O preço deve ser um número. Tente novamente.");
                scanner.nextLine(); // Limpa o scanner em caso de erro.
            }
        }
    }

    // Método para obter uma quantidade válida do usuário.
    private static int obterQuantidadeValida(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Digite a quantidade em estoque: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Limpa o scanner em caso de erro.
                if (quantidade < 0) {
                    System.out.println("ERRO: A quantidade não pode ser negativa. Tente novamente.");
                } else {
                    return quantidade;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO DE ENTRADA: A quantidade deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer do scanner em caso de erro.
            }
        }
    }

    // Método auxiliar para exibir os dados do produto.
    public static void exibirProduto(Produto p) {
        System.out.println("\n--- Dados Atuais do Produto ---");
        System.out.println("Nome: " + p.getNome());
        System.out.printf("Preço: R$%.2f\n", p.getPreco());
        System.out.println("Estoque: " + p.getQuantidadeEmEstoque() + " unidades");
        System.out.println("---------------------------------");
    }
}
