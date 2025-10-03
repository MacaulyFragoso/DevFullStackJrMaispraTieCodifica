package br.com.rh;

import br.com.rh.exception.EntidadeNaoEncontradaException;
import br.com.rh.model.Funcionario;
import br.com.rh.repository.IRepository;
import br.com.rh.repository.InMemoryRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

// Classe principal para interação com o usuário.
public class Main {

    private static final IRepository<Funcionario, Long> funcionarioRepository = new InMemoryRepository<>();
    private static final AtomicLong idGenerator = new AtomicLong(1); // Gera IDs unicos.
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        carregarDadosIniciais();

        while (true) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    buscarFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    removerFuncionario();
                    break;
                case 5:
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- Gestão de Admissão ---");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Buscar Funcionário por ID");
        System.out.println("3. Listar todos os Funcionários");
        System.out.println("4. Remover Funcionário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    private static void cadastrarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        Long novoId = idGenerator.getAndIncrement();
        Funcionario novoFuncionario = new Funcionario(novoId, nome, cargo);
        funcionarioRepository.salvar(novoFuncionario);

        System.out.println("Funcionário cadastrado com sucesso! ID: " + novoId);
    }

    private static void buscarFuncionario() {
        System.out.print("Digite o ID do funcionário: ");
        try {
            Long id = scanner.nextLong();
            Optional<Funcionario> funcionarioOpt = funcionarioRepository.buscarPorId(id);

            if (funcionarioOpt.isPresent()) {
                System.out.println("Funcionário encontrado: " + funcionarioOpt.get());
            } else {
                System.out.println("Funcionário com ID " + id + " nao encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Por favor, digite um número.");
        } finally {
            scanner.nextLine();
        }
    }

    private static void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.listarTodos();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("\n--- Lista de Funcionários ---");
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    private static void removerFuncionario() {
        System.out.print("Digite o ID do funcionário para desligar: ");
        try {
            Long id = scanner.nextLong();
            funcionarioRepository.remover(id);
            System.out.println("Funcionário com ID " + id + " removido com sucesso.");
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Por favor, digite um número.");
        } finally {
            scanner.nextLine();
        }
    }

    private static void carregarDadosIniciais() {
        funcionarioRepository.salvar(new Funcionario(idGenerator.getAndIncrement(), "João Oliveira", "Desenvolvedor Junior"));
        funcionarioRepository.salvar(new Funcionario(idGenerator.getAndIncrement(), "Ana Clara", "Analista de RH"));
    }
}
