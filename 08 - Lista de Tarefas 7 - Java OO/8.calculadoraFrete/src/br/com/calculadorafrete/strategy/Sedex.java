package br.com.calculadorafrete.strategy;

import br.com.calculadorafrete.model.Pedido;
import java.math.BigDecimal;

// Cálculo de frete para Sedex.
public class Sedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {

        return new BigDecimal("10.00");
    }
}

