import java.math.BigDecimal;

public class Item {
    private Long idItem;
    private String descricao;
    private BigDecimal valor;
    private int quantidade;

    public Item(Long idItem, String descricao, BigDecimal valor) {
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

}
