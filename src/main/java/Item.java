import java.math.BigDecimal;

public class Item {
    private Long idItem;
    private String descricao;
    private BigDecimal valor;
    private Double altura = 0.0;
    private Double largura = 0.0;
    private Double profundidade = 0.0;
    private Double peso = 0.0;

    public Item(Long idItem, String descricao, BigDecimal valor) {
        this.idItem = idItem;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Item(Long idItem, String descricao, BigDecimal valor, Double largura, Double altura, Double profundidade, Double peso) {
        this.idItem = idItem;
        this.descricao = descricao;
        this.valor = valor;
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
        this.peso = peso;
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

    public Double getVolume() {
        Double result = Double.valueOf(largura) / 100 * Double.valueOf(altura) / 100 * Double.valueOf(profundidade) / 100;
        return Double.valueOf(result);
    }

    public Double getDensidade() {
        return Double.valueOf(Math.round(this.peso / getVolume()));
    }
}
