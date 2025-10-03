package br.com.calculadorafrete.strategy;

import br.com.calculadorafrete.model.Pedido;
import java.math.BigDecimal;

// Define o contrato para o cálculo de frete.
public interface CalculadoraFrete {
    BigDecimal calcular(Pedido pedido);
}
