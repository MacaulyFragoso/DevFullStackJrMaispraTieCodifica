import java.math.BigDecimal;

// Classe Desenvolvedor que herda de Funcionario.
public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    // Sobrescreve o método para calcular o bônus específico do Desenvolvedor (10%).
    @Override
    public BigDecimal calcularBonus() {
        return salario.multiply(new BigDecimal("0.10"));
    }
}
