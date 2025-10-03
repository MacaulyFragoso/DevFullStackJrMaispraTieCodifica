package br.com.rh.exception;

// Exceção para quando uma entidade não e encontrada.
public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
