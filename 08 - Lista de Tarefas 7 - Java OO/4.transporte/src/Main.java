import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMeioTransporte transporteSelecionado = null;

        while (true) {
            System.out.println("\n--- Simulador de Meios de Transporte ---");
            System.out.println("1: Entrar no Carro");
            System.out.println("2: Subir na Bicicleta");
            System.out.println("3: Entrar no Trem");
            System.out.println("0: Sair do simulador");
            System.out.print("Escolha uma ação: ");

            try {
                int escolha = scanner.nextInt();

                if (escolha == 0) {
                    System.out.println("Saindo do simulador.");
                    break;
                }

                switch (escolha) {
                    case 1:
                        transporteSelecionado = new Carro();
                        break;
                    case 2:
                        transporteSelecionado = new Bicicleta();
                        break;
                    case 3:
                        transporteSelecionado = new Trem();
                        break;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                        continue;
                }

                String nomeTransporte = transporteSelecionado.getClass().getSimpleName();
                System.out.println("\nVocê está no(a) " + nomeTransporte + ".");
                System.out.println("Velocímetro - Velocidade Máxima: " + transporteSelecionado.getVelocidadeMaxima() + " km/h");


                // Loop de ações para o transporte selecionado
                while (true) {
                    System.out.println("\n--- O que fazer com o(a) " + nomeTransporte + "? ---");
                    System.out.println("1: Acelerar");
                    System.out.println("2: Frear");
                    System.out.println("3: Descer do(a) " + nomeTransporte);
                    System.out.print("Escolha a ação: ");

                    int acao = scanner.nextInt();

                    try {
                        if (acao == 1) {
                            transporteSelecionado.acelerar();
                        } else if (acao == 2) {
                            transporteSelecionado.frear();
                        } else if (acao == 3) {
                            if (transporteSelecionado.getVelocidade() == 0) {
                                System.out.println("Você desceu do(a) " + nomeTransporte + ".");
                                break;
                            } else {
                                System.out.println("Você precisa parar o(a) " + nomeTransporte + " antes de descer!");
                            }
                        } else {
                            System.out.println("Ação inválida.");
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(" " + e.getMessage());
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite apenas números.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
        scanner.close();
    }
}
