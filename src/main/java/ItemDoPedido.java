import java.math.BigDecimal;

public class ItemDoPedido {
    private final Long idItem;
    private final String descricao;
    private final BigDecimal valor;
    private final int quantidade;

    public ItemDoPedido(Long idItem, String descricao, BigDecimal valor, int quantidade) {
        this.idItem = idItem;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Long getIdItem() {
        return idItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal valorTotal() {
        return BigDecimal.valueOf(quantidade).multiply(valor);
    }
}
