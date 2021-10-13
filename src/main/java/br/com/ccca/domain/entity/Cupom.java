package br.com.ccca.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cupom {

    private final String codigo;
    private final int percentual;
    private LocalDate dataExpiracao;

    public Cupom(String codigo, int percentual, LocalDate dataExpiracao) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.dataExpiracao = dataExpiracao;
    }

    public BigDecimal aplicarDesconto(BigDecimal valor, LocalDate dataAtual) {
        if (cupomExpirado(dataAtual)) return valor;
        BigDecimal desconto = valor
                .multiply(BigDecimal.valueOf(percentual))
                .divide(BigDecimal.valueOf(100));
        return valor.subtract(desconto);
    }

    private boolean cupomExpirado(LocalDate dataAtual) {
        return dataExpiracao.isBefore(dataAtual);
    }
}
