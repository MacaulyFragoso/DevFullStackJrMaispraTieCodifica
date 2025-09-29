package com.pagamentos;

// Forma de pagamento Boleto.
public class Boleto extends FormaPagamento {

    private final String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        // Valida se o código de barras contém exatamente 18 dígitos numéricos.
        if (codigoBarras == null || !codigoBarras.matches("^\\d{18}$")) {
            throw new PagamentoInvalidoException("Código de barras inválido. Deve conter 18 dígitos numéricos.");
        }
    }
}

