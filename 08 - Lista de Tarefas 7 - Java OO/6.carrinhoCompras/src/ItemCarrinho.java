import java.math.BigDecimal;

// Representa um item dentro do carrinho, associando um Produto a uma quantidade.
public final class ItemCarrinho {

    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Calcula o subtotal do item.
    public Dinheiro getSubtotal() {
        BigDecimal subtotalValor = produto.getPreco().getValor().multiply(new BigDecimal(quantidade));
        return new Dinheiro(subtotalValor, produto.getPreco().getMoeda());
    }

    @Override
    public String toString() {
        return produto.getNome() + " (Qtd: " + quantidade + ", Subtotal: " + getSubtotal() + ")";
    }
}
