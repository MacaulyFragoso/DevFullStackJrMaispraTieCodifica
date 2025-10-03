import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Classe principal do carrinho.
public final class Carrinho {

    private final List<ItemCarrinho> itens;
    private final int cupomDesconto;

    // Construtor para um carrinho vazio.
    public Carrinho() {
        this.itens = Collections.emptyList();
        this.cupomDesconto = 0;
    }

    // Construtor privado usado internamente para criar novas instâncias.
    private Carrinho(List<ItemCarrinho> itens, int cupomDesconto) {
        this.itens = new ArrayList<>(itens);
        this.cupomDesconto = cupomDesconto;
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public int getCupomDesconto() {
        return cupomDesconto;
    }

    // Retorna um NOVO carrinho com o item adicionado ou atualizado.
    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);

        boolean itemExistente = false;
        for (int i = 0; i < novosItens.size(); i++) {
            ItemCarrinho item = novosItens.get(i);
            if (item.getProduto().equals(produto)) {
                int novaQuantidade = item.getQuantidade() + quantidade;
                novosItens.set(i, new ItemCarrinho(produto, novaQuantidade));
                itemExistente = true;
                break;
            }
        }

        if (!itemExistente) {
            novosItens.add(new ItemCarrinho(produto, quantidade));
        }

        return new Carrinho(novosItens, this.cupomDesconto);
    }

    // Retorna um NOVO carrinho com o item removido.
    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novosItens = new ArrayList<>();
        for (ItemCarrinho item : this.itens) {
            if (!item.getProduto().equals(produto)) {
                novosItens.add(item);
            }
        }
        return new Carrinho(novosItens, this.cupomDesconto);
    }

    // Retorna um NOVO carrinho com o cupom aplicado.
    public Carrinho aplicarCupom(int percentual) {
        if (percentual < 0 || percentual > 30) {
            throw new IllegalArgumentException("Cupom de desconto deve ser entre 0 e 30%.");
        }
        return new Carrinho(this.itens, percentual);
    }

    // Calcula o subtotal (soma dos itens) antes de qualquer desconto.
    public Dinheiro getValorSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        Moeda moeda = Moeda.BRL;

        if (!itens.isEmpty()) {
            moeda = itens.get(0).getProduto().getPreco().getMoeda();
        }

        for (ItemCarrinho item : itens) {
            subtotal = subtotal.add(item.getSubtotal().getValor());
        }
        return new Dinheiro(subtotal.setScale(2, RoundingMode.HALF_EVEN), moeda);
    }

    // Calcula o valor total, aplicando o desconto.
    public Dinheiro getValorTotal() {
        Dinheiro subtotal = getValorSubtotal();
        BigDecimal total = subtotal.getValor();

        if (cupomDesconto > 0) {
            BigDecimal multiplicador = BigDecimal.valueOf(cupomDesconto).divide(new BigDecimal("100"));
            BigDecimal valorDesconto = total.multiply(multiplicador);
            total = total.subtract(valorDesconto);
        }

        // Arredondamento bancário (HALF_EVEN).
        return new Dinheiro(total.setScale(2, RoundingMode.HALF_EVEN), subtotal.getMoeda());
    }
}

