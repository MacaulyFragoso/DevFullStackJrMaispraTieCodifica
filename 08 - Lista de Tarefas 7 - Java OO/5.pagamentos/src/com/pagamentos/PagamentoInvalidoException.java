package com.pagamentos;

public class PagamentoInvalidoException extends Exception {
    public PagamentoInvalidoException(String message) {
        super(message);
    }
}
