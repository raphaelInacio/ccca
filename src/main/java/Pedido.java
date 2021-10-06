import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemDoPedido> itens;
    private Cpf Cpf;
    private Cupom cupom;

    public Pedido(String cpf) {
        this.Cpf = new Cpf(cpf);
        this.itens = new ArrayList<>();
    }

    public int totalDeItens() {
        return itens.size();
    }

    public void adcionarItem(Item item, int quantidade) {
        this.itens.add(new ItemDoPedido(item.getIdItem(), item.getDescricao(), item.getValor(), quantidade));
    }

    public void adicionarCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public BigDecimal valorTotal() {
        BigDecimal valorTotal
                = itens.stream()
                .map(ItemDoPedido::valorTotal)
                .reduce(BigDecimal::add)
                .get();
        if (cupom != null) {
            return cupom.aplicarDesconto(valorTotal);
        }
        return valorTotal;
    }


}
