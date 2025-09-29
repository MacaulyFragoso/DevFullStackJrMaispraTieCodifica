package com.pagamentos;

import java.math.BigDecimal;

// Formas de pagamento.
public abstract class FormaPagamento {

    // Método abstrato que força as classes filhas a implementarem sua própria lógica de validação.
    public abstract void validarPagamento() throws PagamentoInvalidoException;

    // Método concreto que processa o pagamento.
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " processado com sucesso via " + this.getClass().getSimpleName() + ".");
    }
}
