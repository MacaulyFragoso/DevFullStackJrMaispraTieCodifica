package com.pagamentos;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

// Interação com o usuário.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Loop principal do menu.
            System.out.println("\n===== SISTEMA DE PAGAMENTOS =====");
            System.out.println("1 - Pagar com Cartão de Crédito");
            System.out.println("2 - Pagar com Boleto");
            System.out.println("3 - Pagar com Pix");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Opção inválida. Por favor, digite um número.");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            if (opcao == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }

            switch (opcao) {
                case 1:
                    handlePagamentoCartao(scanner);
                    break;
                case 2:
                    handlePagamentoBoleto(scanner);
                    break;
                case 3:
                    handlePagamentoPix(scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void handlePagamentoCartao(Scanner scanner) {
        // Passo 1: Obter Valor
        while (true) {
            System.out.print("Digite o valor do pagamento ou 'V' para voltar ao menu principal: ");
            String inputValor = scanner.nextLine();

            if (inputValor.equalsIgnoreCase("V")) {
                return; // Volta ao menu principal
            }

            BigDecimal valor;
            try {
                valor = new BigDecimal(inputValor.replace(',', '.'));
                if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Erro: O valor do pagamento deve ser positivo.");
                    continue; // Pede o valor novamente
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Valor inválido. Use números e um separador decimal.");
                continue; // Pede o valor novamente
            }

            // Passo 2: Obter Dados do Cartão
            while (true) {
                System.out.print("Digite o número do cartão (16 dígitos, ex: 1111222233334444) ou 'V' para alterar o valor: ");
                String numeroCartao = scanner.nextLine();

                if (numeroCartao.equalsIgnoreCase("V")) {
                    break; // Sai do loop de dados, volta para o loop de valor
                }

                FormaPagamento formaPagamento = new CartaoCredito(numeroCartao);
                try {
                    System.out.println("\n--- Processando pagamento ---");
                    formaPagamento.processarPagamento(valor);
                    return; // Sucesso, volta ao menu principal
                } catch (PagamentoInvalidoException e) {
                    System.out.println("Erro no pagamento: " + e.getMessage());
                    // Continua no loop de dados para nova tentativa
                }
            }
        }
    }

    private static void handlePagamentoBoleto(Scanner scanner) {
        // Passo 1: Obter Valor
        while (true) {
            System.out.print("Digite o valor do pagamento ou 'V' para voltar ao menu principal: ");
            String inputValor = scanner.nextLine();

            if (inputValor.equalsIgnoreCase("V")) {
                return; // Volta ao menu principal
            }

            BigDecimal valor;
            try {
                valor = new BigDecimal(inputValor.replace(',', '.'));
                if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Erro: O valor do pagamento deve ser positivo.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Valor inválido. Use números e um separador decimal.");
                continue;
            }

            // Passo 2: Obter Dados do Boleto
            while (true) {
                System.out.print("Digite o código de barras (18 dígitos, ex: 123412341234123412) ou 'V' para alterar o valor: ");
                String codigoBarras = scanner.nextLine();

                if (codigoBarras.equalsIgnoreCase("V")) {
                    break; // Volta para o passo do valor
                }

                FormaPagamento formaPagamento = new Boleto(codigoBarras);
                try {
                    System.out.println("\n--- Processando pagamento ---");
                    formaPagamento.processarPagamento(valor);
                    return; // Sucesso, volta ao menu principal
                } catch (PagamentoInvalidoException e) {
                    System.out.println("Erro no pagamento: " + e.getMessage());
                }
            }
        }
    }

    private static void handlePagamentoPix(Scanner scanner) {
        // Passo 1: Obter Valor
        while (true) {
            System.out.print("Digite o valor do pagamento ou 'V' para voltar ao menu principal: ");
            String inputValor = scanner.nextLine();

            if (inputValor.equalsIgnoreCase("V")) {
                return;
            }

            BigDecimal valor;
            try {
                valor = new BigDecimal(inputValor.replace(',', '.'));
                if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("Erro: O valor do pagamento deve ser positivo.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Valor inválido. Use números e um separador decimal.");
                continue;
            }

            // Passo 2: Obter Tipo de Chave
            while (true) {
                System.out.println("\n--- TIPO DE CHAVE PIX ---");
                System.out.println("1 - Email");
                System.out.println("2 - Chave Aleatória");
                System.out.println("3 - Número de Telefone");
                System.out.println("4 - CPF");
                System.out.print("Escolha o tipo de chave ou 'V' para voltar à digitação do valor: ");

                String inputTipoChave = scanner.nextLine();

                if (inputTipoChave.equalsIgnoreCase("V")) {
                    break; // Volta para o passo do valor
                }

                int tipoChave;
                try {
                    tipoChave = Integer.parseInt(inputTipoChave);
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Opção inválida. Digite um número de 1 a 4 ou 'V'.");
                    continue;
                }

                if (tipoChave < 1 || tipoChave > 4) {
                    System.out.println("Tipo de chave inválido.");
                    continue;
                }

                // Passo 3: Obter Valor da Chave
                while(true) {
                    String prompt;
                    TipoChavePix tipoChavePixEnum;
                    switch (tipoChave) {
                        case 1: prompt = "Digite o Email (ex: seuemail@dominio.com)"; tipoChavePixEnum = TipoChavePix.EMAIL; break;
                        case 2: prompt = "Digite a Chave Aleatória (8 caracteres, ex: a1b2c3d4)"; tipoChavePixEnum = TipoChavePix.CHAVE_ALEATORIA; break;
                        case 3: prompt = "Digite o Número de Telefone (10 a 11 dígitos, ex: 11987654321)"; tipoChavePixEnum = TipoChavePix.TELEFONE; break;
                        case 4: prompt = "Digite o CPF (11 dígitos, ex: 12345678901)"; tipoChavePixEnum = TipoChavePix.CPF; break;
                        default: return;
                    }
                    System.out.print(prompt + " ou 'V' para voltar à seleção do tipo de chave: ");
                    String chavePixValor = scanner.nextLine();

                    if (chavePixValor.equalsIgnoreCase("V")) {
                        break; // Volta para o passo de tipo de chave
                    }

                    FormaPagamento formaPagamento = new Pix(chavePixValor, tipoChavePixEnum);
                    try {
                        System.out.println("\n--- Processando pagamento ---");
                        formaPagamento.processarPagamento(valor);
                        return; // Sucesso, volta ao menu principal
                    } catch (PagamentoInvalidoException e) {
                        System.out.println("Erro no pagamento: " + e.getMessage());
                        // Continua neste loop para nova tentativa
                    }
                }
            }
        }
    }
}

