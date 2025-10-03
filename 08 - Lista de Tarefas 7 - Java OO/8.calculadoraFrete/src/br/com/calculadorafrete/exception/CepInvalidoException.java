package br.com.calculadorafrete.exception;

// Exceção para tratar CEPs inválidos.
public class CepInvalidoException extends Exception {
    public CepInvalidoException(String message) {
        super(message);
    }
}
