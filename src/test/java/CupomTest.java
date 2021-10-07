import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CupomTest {

    @Test
    void aplicarDescontoDeDezPorCento() {
        Cupom vale10 = new Cupom("VALE10", 10, LocalDate.of(2021, 12, 14));
        Assertions.assertEquals(BigDecimal.valueOf(90), vale10.aplicarDesconto(BigDecimal.valueOf(100), LocalDate.of(2021, 10, 14)));
    }

    @Test
    void naoDeveAplicarDescontoEmUmCupomExpirado() {
        Cupom vale10 = new Cupom("VALE10", 10, LocalDate.of(2021, 11, 14));
        Assertions.assertEquals(BigDecimal.valueOf(100), vale10.aplicarDesconto(BigDecimal.valueOf(100), LocalDate.of(2021, 12, 14)));
    }
}