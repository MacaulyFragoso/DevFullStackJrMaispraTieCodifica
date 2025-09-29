import java.math.BigDecimal;

// Classe abstrata base para todos os funcionários.
public abstract class Funcionario {

    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    // Método abstrato para forçar as classes filhas a implementarem o cálculo do bônus.
    public abstract BigDecimal calcularBonus();
}
