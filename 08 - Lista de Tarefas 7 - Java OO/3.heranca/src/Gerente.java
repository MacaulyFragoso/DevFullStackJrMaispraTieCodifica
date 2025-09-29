import java.math.BigDecimal;

// Classe Gerente que herda de Funcionario.
public class Gerente extends Funcionario {

    public Gerente(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    // Sobrescreve o método para calcular o bônus específico do Gerente (20%).
    @Override
    public BigDecimal calcularBonus() {
        return salario.multiply(new BigDecimal("0.20"));
    }
}
