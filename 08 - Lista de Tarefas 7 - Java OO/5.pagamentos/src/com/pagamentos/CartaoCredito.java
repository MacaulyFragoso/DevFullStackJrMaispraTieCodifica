package com.pagamentos;

// Forma de pagamento Cartão de Crédito.
public class CartaoCredito extends FormaPagamento {

    private final String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        // Verifica se o número do cartão tem 16 dígitos númericos.
        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            throw new PagamentoInvalidoException("Número de cartão de crédito inválido.");
        }
    }
}
