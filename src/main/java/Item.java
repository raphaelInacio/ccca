import java.math.BigDecimal;

public class Item {
    private Long idItem;
    private String descricao;
    private BigDecimal valor;
    private Long altura = 0L;
    private Long largura = 0L;
    private Long profundidade = 0L;
    private Long peso;

    public Item(Long idItem, String descricao, BigDecimal valor) {
        this.idItem = idItem;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Item(Long idItem, String descricao, BigDecimal valor, Long largura, Long altura, Long profundidade, Long peso) {
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
        return this.peso / getVolume();
    }
}
