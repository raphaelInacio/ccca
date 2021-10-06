import java.math.BigDecimal;

public class Cupom {

    private final String nome;
    private final int percentual;

    public Cupom(String nome, int percentual) {
        this.nome = nome;
        this.percentual = percentual;
    }

    public BigDecimal aplicarDesconto(BigDecimal valor) {
        BigDecimal desconto = valor.multiply(new BigDecimal(percentual)).divide(new BigDecimal(100));
        return valor.subtract(desconto);
    }
}
