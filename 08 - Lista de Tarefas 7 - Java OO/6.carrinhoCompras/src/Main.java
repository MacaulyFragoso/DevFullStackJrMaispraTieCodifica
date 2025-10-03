import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal para demonstrar o fluxo de compra e a interação.
public class Main {

    private static List<Produto> produtosDisponiveis = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializa os produtos da loja
        inicializarProdutos();

        Scanner scanner = new Scanner(System.in);
        Carrinho carrinhoAtual = new Carrinho();

        System.out.println("--- Carrinho de Compras! ---");

        while (true) {
            exibirEstadoCarrinho(carrinhoAtual);
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            try {
                switch (opcao) {
                    case "1":
                        carrinhoAtual = handleAdicionarItem(scanner, carrinhoAtual);
                        break;
                    case "2":
                        carrinhoAtual = handleRemoverItem(scanner, carrinhoAtual);
                        break;
                    case "3":
                        carrinhoAtual = handleAplicarCupom(scanner, carrinhoAtual);
                        break;
                    case "4":
                        System.out.println("Obrigado por comprar conosco!");
                        return; // Sai do programa
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                // Captura exceções de validação e informa o usuário.
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
            System.out.println("\n--------------------------------------------------\n");
        }
    }

    private static Carrinho handleAdicionarItem(Scanner scanner, Carrinho carrinho) {
        System.out.println("\n--- Produtos Disponíveis ---");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + produtosDisponiveis.get(i));
        }

        System.out.print("Digite o número do produto para adicionar: ");
        int indiceProduto = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceProduto < 0 || indiceProduto >= produtosDisponiveis.size()) {
            System.out.println("Produto inválido.");
            return carrinho;
        }

        System.out.print("Digite a quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        Produto produtoSelecionado = produtosDisponiveis.get(indiceProduto);
        Carrinho novoCarrinho = carrinho.adicionarItem(produtoSelecionado, quantidade);

        System.out.println("\n'" + produtoSelecionado.getNome() + "' adicionado ao carrinho.");
        return novoCarrinho;
    }

    private static Carrinho handleRemoverItem(Scanner scanner, Carrinho carrinho) {
        if (carrinho.getItens().isEmpty()) {
            System.out.println("O carrinho já está vazio.");
            return carrinho;
        }

        System.out.println("\n--- Itens no Carrinho ---");
        for (int i = 0; i < carrinho.getItens().size(); i++) {
            System.out.println((i + 1) + " - " + carrinho.getItens().get(i).getProduto().getNome());
        }

        System.out.print("Digite o número do produto para remover: ");
        int indiceProduto = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceProduto < 0 || indiceProduto >= carrinho.getItens().size()) {
            System.out.println("Item inválido.");
            return carrinho;
        }

        Produto produtoARemover = carrinho.getItens().get(indiceProduto).getProduto();
        Carrinho novoCarrinho = carrinho.removerItem(produtoARemover);

        System.out.println("\n'" + produtoARemover.getNome() + "' removido do carrinho.");
        return novoCarrinho;
    }

    private static Carrinho handleAplicarCupom(Scanner scanner, Carrinho carrinho) {
        System.out.print("Digite o percentual de desconto entre 0 e 30 ");
        int percentual = Integer.parseInt(scanner.nextLine());

        Carrinho novoCarrinho = carrinho.aplicarCupom(percentual);

        System.out.println("\nCupom de " + percentual + "% aplicado.");
        return novoCarrinho;
    }

    private static void inicializarProdutos() {
        produtosDisponiveis.add(new Produto("Notebook Gamer", new Dinheiro(new BigDecimal("7500.00"), Moeda.BRL)));
        produtosDisponiveis.add(new Produto("Mouse sem Fio", new Dinheiro(new BigDecimal("150.00"), Moeda.BRL)));
        produtosDisponiveis.add(new Produto("Teclado Mecânico", new Dinheiro(new BigDecimal("450.00"), Moeda.BRL)));
    }

    private static void exibirEstadoCarrinho(Carrinho carrinho) {
        System.out.println("=== SEU CARRINHO ATUAL ===");
        if (carrinho.getItens().isEmpty()) {
            System.out.println("O carrinho está vázio.");
        } else {
            Moeda moedaUsada = carrinho.getItens().get(0).getProduto().getPreco().getMoeda();
            System.out.println("Moeda: " + moedaUsada.getDescricao());
            for (ItemCarrinho item : carrinho.getItens()) {
                System.out.println("- " + item);
            }
            System.out.println("--------------------------------");

            Dinheiro subtotal = carrinho.getValorSubtotal();
            System.out.println("Subtotal: " + subtotal);

            if (carrinho.getCupomDesconto() > 0) {
                int percentual = carrinho.getCupomDesconto();
                BigDecimal multiplicador = BigDecimal.valueOf(percentual).divide(new BigDecimal("100"));
                BigDecimal valorDesconto = subtotal.getValor().multiply(multiplicador);

                Dinheiro descontoFormatado = new Dinheiro(valorDesconto.setScale(2, RoundingMode.HALF_EVEN), subtotal.getMoeda());

                System.out.println("Cupom Aplicado: " + percentual + "% (Desconto de " + descontoFormatado + ")");
            }
        }

        System.out.println("Total: " + carrinho.getValorTotal());
        System.out.println("================================");
    }

    private static void exibirMenu() {
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Adicionar item");
        System.out.println("2 - Remover item");
        System.out.println("3 - Aplicar cupom de desconto");
        System.out.println("4 - Sair");
    }
}
