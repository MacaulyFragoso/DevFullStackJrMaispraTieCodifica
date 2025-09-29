import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();

        // Loop principal do menu.
        while (true) {
            System.out.println("\n--- CÁLCULO DE BÔNUS DE NATAL ---");
            System.out.println("1. Registrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Reiniciar");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    registrarFuncionario(scanner, funcionarios);
                    break;
                case "2":
                    listarFuncionarios(funcionarios);
                    break;
                case "3":
                    funcionarios.clear();
                    System.out.println("A lista de bônus foi limpa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void registrarFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.print("\nDigite o nome do funcionário: ");
        String nome = scanner.nextLine();

        // Validação do salário.
        BigDecimal salario = null;
        while (salario == null) {
            System.out.print("Digite o salário: ");
            String salarioStr = scanner.nextLine();
            try {
                BigDecimal valor = new BigDecimal(salarioStr);
                if (valor.compareTo(BigDecimal.ZERO) > 0) {
                    salario = valor;
                } else {
                    System.out.println("Erro: O salário deve ser um valor positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Formato de salário inválido. Use '.' como separador decimal.");
            }
        }

        // Validação do cargo e criação do objeto.
        Funcionario novoFuncionario = null;
        while (novoFuncionario == null) {
            System.out.println("Digite o cargo:");
            System.out.println("1. Gerente");
            System.out.println("2. Desenvolvedor");
            System.out.print("Escolha uma opção: ");
            String cargoOpcao = scanner.nextLine().trim();

            switch (cargoOpcao) {
                case "1":
                    novoFuncionario = new Gerente(nome, salario);
                    break;
                case "2":
                    novoFuncionario = new Desenvolvedor(nome, salario);
                    break;
                default:
                    System.out.println("Erro: Opção de cargo inválida. Por favor, insira '1' ou '2'.");
            }
        }

        funcionarios.add(novoFuncionario);

        // Exibe a prévia do funcionário recém-registrado.
        System.out.println("\n--- Bônus registrado com sucesso! ---");
        BigDecimal bonus = novoFuncionario.calcularBonus();
        BigDecimal total = novoFuncionario.getSalario().add(bonus);

        System.out.println("----------------------------------------");
        System.out.println("Nome: " + novoFuncionario.getNome());
        System.out.println("Cargo: " + novoFuncionario.getClass().getSimpleName());
        System.out.printf("Salário: R$ %.2f\n", novoFuncionario.getSalario());
        System.out.printf("Bônus: R$ %.2f\n", bonus);
        System.out.printf("Total com Bônus: R$ %.2f\n", total);
        System.out.println("----------------------------------------");
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS E BÔNUS ---");

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário registrado.");
            return;
        }

        for (Funcionario f : funcionarios) {
            BigDecimal bonus = f.calcularBonus();
            BigDecimal total = f.getSalario().add(bonus);

            System.out.println("----------------------------------------");
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getClass().getSimpleName());
            System.out.printf("Salário: R$ %.2f\n", f.getSalario());
            System.out.printf("Bônus: R$ %.2f\n", bonus);
            System.out.printf("Total com Bônus: R$ %.2f\n", total);
        }
        System.out.println("----------------------------------------");
    }
}

