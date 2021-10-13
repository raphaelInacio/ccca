package br.com.ccca.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemDoPedido> itens;
    private Cpf Cpf;
    private LocalDate dataPedido;
    private Cupom cupom;
    private double frete = 0.0;
    private static final double DISTANCIA = 1000;
    private static final double FRETE_MINIMO = 10.00;

    public Pedido(String cpf, LocalDate dataPedido) {
        this.Cpf = new Cpf(cpf);
        this.dataPedido = dataPedido;
        this.itens = new ArrayList<>();
    }

    public int totalDeItens() {
        return itens.size();
    }

    public void adcionarItem(Item item, int quantidade) {
        this.frete += ((DISTANCIA * item.getVolume() * (item.getDensidade() / 100)) * quantidade);
        this.itens.add(new ItemDoPedido(item.getIdItem(), item.getDescricao(), item.getValor(), quantidade));
    }

    public void adicionarCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public BigDecimal calcularValorDoPedido() {
        BigDecimal valorTotal
                = itens.stream()
                .map(ItemDoPedido::valorTotal)
                .reduce(BigDecimal::add)
                .get();
        return cupom == null ? valorTotal : cupom.aplicarDesconto(valorTotal, dataPedido);
    }

    public double obterFrete() {
        return this.frete <= FRETE_MINIMO ? FRETE_MINIMO : this.frete;
    }
}
