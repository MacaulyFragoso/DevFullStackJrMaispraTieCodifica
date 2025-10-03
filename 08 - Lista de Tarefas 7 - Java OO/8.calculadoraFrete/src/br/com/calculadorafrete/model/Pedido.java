package br.com.calculadorafrete.model;

import br.com.calculadorafrete.exception.CepInvalidoException;
import br.com.calculadorafrete.strategy.CalculadoraFrete;
import java.math.BigDecimal;

// Representa o pedido e mantém a estratégia de frete.
public class Pedido {

    private BigDecimal valor;
    private String cepDestino;
    private CalculadoraFrete calculadoraFrete;

    public Pedido(BigDecimal valor, String cepDestino) throws CepInvalidoException {
        if (!validaCep(cepDestino)) {
            throw new CepInvalidoException("CEP inválido. Deve conter 8 dígitos numéricos.");
        }
        this.valor = valor;
        this.cepDestino = cepDestino;
    }

    // Validação simples do CEP.
    private boolean validaCep(String cep) {
        if (cep == null || cep.length() != 8) {
            return false;
        }
        return cep.matches("[0-9]+");
    }

    public void setCalculadoraFrete(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal calcularFrete() {

        return this.calculadoraFrete.calcular(this);
    }
}
