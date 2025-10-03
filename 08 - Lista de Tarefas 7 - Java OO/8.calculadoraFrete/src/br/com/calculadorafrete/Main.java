package br.com.calculadorafrete;

import br.com.calculadorafrete.exception.CepInvalidoException;
import br.com.calculadorafrete.model.Pedido;
import br.com.calculadorafrete.strategy.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(" ----- Calcular Frete -----");

            BigDecimal valorPedido = null;
            while (valorPedido == null) {
                try {
                    System.out.print(" Digite o valor do pedido: ");
                    valorPedido = scanner.nextBigDecimal();
                } catch (InputMismatchException e) {
                    System.err.println("\n Erro: Valor inválido. Por favor, digite um número (ex: 150.50).");
                    scanner.next();
                }
            }

            Pedido pedido = null;
            while (pedido == null) {
                try {
                    System.out.print(" Digite o CEP de destino (apenas 8 números): ");
                    String cep = scanner.next();
                    pedido = new Pedido(valorPedido, cep);
                } catch (CepInvalidoException e) {
                    System.err.println("\n Erro: " + e.getMessage() + " Por favor, tente novamente.");
                }
            }
            System.out.println("\n Pedido criado com sucesso!");

            boolean isPromocaoApta = valorPedido.compareTo(new BigDecimal("150.00")) > 0;
            if (isPromocaoApta) {
                System.out.println("\n🎉 Parabéns! Seu pedido é elegível para Frete Grátis!");
            }

            while (true) {
                int opcao = -1;
                try {
                    System.out.println("\n Selecione uma opção de frete para simular o valor: ");
                    System.out.println(" 1 - SEDEX (R$ 10,00)");
                    System.out.println(" 2 - PAC (R$ 5,00)");
                    System.out.println(" 3 - Retirada na Loja (Grátis)");
                    System.out.println(" 0 - Sair");
                    System.out.print(" Opção: ");
                    opcao = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("\n Erro: Opção inválida. Por favor, digite um dos números do menu.");
                    scanner.next();
                    continue;
                }

                if (opcao == 0) {
                    System.out.println("\n Pedido cancelado.");
                    break;
                }

                String nomeEstrategia;

                // Injeta a estratégia escolhida no objeto Pedido.
                switch (opcao) {
                    case 1:
                        pedido.setCalculadoraFrete(new Sedex());
                        nomeEstrategia = "SEDEX";
                        break;
                    case 2:
                        pedido.setCalculadoraFrete(new Pac());
                        nomeEstrategia = "PAC";
                        break;
                    case 3:
                        pedido.setCalculadoraFrete(new RetiradaNaLoja());
                        nomeEstrategia = "Retirada na Loja";
                        break;
                    default:
                        System.out.println("\n Opção inválida. Tente novamente.");
                        continue;
                }

                // Utiliza o método da classe Pedido para calcular, que por sua vez usa a Strategy.
                BigDecimal custoBase = pedido.calcularFrete();

                BigDecimal custoFinal = isPromocaoApta ? BigDecimal.ZERO : custoBase;
                BigDecimal valorTotal = valorPedido.add(custoFinal);

                System.out.printf("\n ----- Simulação de Frete: %s -----\n", nomeEstrategia);
                if (isPromocaoApta) {
                    System.out.println(" Promoção Frete Grátis aplicada!");
                }
                System.out.printf(" Custo do Frete: R$ %.2f\n", custoFinal);
                System.out.printf(" Valor Total do Pedido: R$ %.2f\n", valorTotal);

                System.out.print("\n Deseja finalizar o pedido сom esta opção? (S/N): ");
                String confirmacao = scanner.next();

                if (confirmacao.equalsIgnoreCase("S")) {
                    System.out.printf("\n----- Pedido Finalizado -----\n");
                    System.out.printf(" Opção de Frete Escolhida: %s\n", nomeEstrategia);
                    System.out.printf(" Custo do Frete: R$ %.2f\n", custoFinal);
                    System.out.printf(" Valor Total (Pedido + Frete): R$ %.2f\n", valorTotal);
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("\n Ocorreu um erro inesperado no programa.");
        } finally {
            scanner.close();
        }
    }
}
