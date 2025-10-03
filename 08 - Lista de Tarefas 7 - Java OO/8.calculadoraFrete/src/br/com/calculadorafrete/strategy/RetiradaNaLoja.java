package br.com.calculadorafrete.strategy;

import br.com.calculadorafrete.model.Pedido;
import java.math.BigDecimal;

// Retirada na loja não tem custo.
public class RetiradaNaLoja implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return BigDecimal.ZERO;
    }
}
