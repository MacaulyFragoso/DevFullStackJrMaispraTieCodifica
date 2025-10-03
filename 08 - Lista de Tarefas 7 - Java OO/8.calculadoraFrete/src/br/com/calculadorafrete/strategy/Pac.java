package br.com.calculadorafrete.strategy;

import br.com.calculadorafrete.model.Pedido;
import java.math.BigDecimal;

// Cálculo de frete para PAC.
public class Pac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {

        return new BigDecimal("5.00");
    }
}
