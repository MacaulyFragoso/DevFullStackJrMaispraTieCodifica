package com.pagamentos;

// Forma de pagamento Pix com validações específicas por tipo de chave.
public class Pix extends FormaPagamento {

    private final String chavePix;
    private final TipoChavePix tipoChave;

    public Pix(String chavePix, TipoChavePix tipoChave) {
        this.chavePix = chavePix;
        this.tipoChave = tipoChave;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("A chave Pix não pode ser nula ou vazia.");
        }

        switch (tipoChave) {
            case EMAIL:
                // Validação simples de email.
                if (!chavePix.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    throw new PagamentoInvalidoException("Formato de email inválido para a chave Pix.");
                }
                break;

            case CPF:
                // Validação de CPF (apenas dígitos, 11 caracteres).
                if (!chavePix.matches("^\\d{11}$")) {
                    throw new PagamentoInvalidoException("Formato de CPF inválido. A chave deve conter 11 dígitos.");
                }
                break;

            case TELEFONE:
                // Validação de Telefone (formato simples com 10 a 11 dígitos).
                if (!chavePix.matches("^\\d{10,11}$")) {
                    throw new PagamentoInvalidoException("Formato de telefone inválido. A chave deve conter 10 ou 11 dígitos.");
                }
                break;

            case CHAVE_ALEATORIA:
                // Validação de Chave Aleatória (8 caracteres alfanuméricos).
                if (!chavePix.matches("^[a-zA-Z0-9]{8}$")) {
                    throw new PagamentoInvalidoException("Formato de chave aleatória inválido. Deve conter 8 caracteres alfanuméricos.");
                }
                break;

            default:
                throw new PagamentoInvalidoException("Tipo de chave Pix desconhecido.");
        }
    }
}

