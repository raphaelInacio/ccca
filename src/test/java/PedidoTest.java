import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PedidoTest {

    @Test
    void naoDeveCriarUmPedidoComCPFInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Pedido("111.111.111-11"));
    }

    @Test
    void deveCriarUmPedidoComTresItens() {
        Pedido pedido = new Pedido("326.873.088-46");
        Item macBookPro = new Item(1L, "Mac book pro", new BigDecimal(10000));
        Item magicMouse = new Item(2L, "Magic Mouse", new BigDecimal(1000));
        Item magicBoard = new Item(3L, "Magic board", new BigDecimal(1500));
        pedido.adcionarItem(macBookPro, 1);
        pedido.adcionarItem(magicBoard, 1);
        pedido.adcionarItem(magicMouse, 1);
        Assertions.assertEquals(3, pedido.totalDeItens());
    }

    @Test
    void deveAplicarPercentualDeDescontoSobreUmPedido() {
        Cupom descontoDezPorcento = new Cupom("VALE10", 10);
        Pedido pedido = new Pedido("326.873.088-46");
        Item macBookPro = new Item(1L, "Mac book pro", new BigDecimal(10000));
        Item magicMouse = new Item(2L, "Magic Mouse", new BigDecimal(1000));
        Item magicBoard = new Item(3L, "Magic board", new BigDecimal(1500));
        pedido.adcionarItem(macBookPro, 1);
        pedido.adcionarItem(magicBoard, 1);
        pedido.adcionarItem(magicMouse, 1);
        pedido.adicionarCupom(descontoDezPorcento);
        Assertions.assertEquals(new BigDecimal(11250), pedido.valorTotal());
    }

    @Test
    void quandoNaoInformadoCupomDeDescontoDeveSerAplicadoValorCheio() {
        Pedido pedido = new Pedido("326.873.088-46");
        Item macBookPro = new Item(1L, "Mac book pro", new BigDecimal(10000));
        Item magicMouse = new Item(2L, "Magic Mouse", new BigDecimal(1000));
        Item magicBoard = new Item(3L, "Magic board", new BigDecimal(1500));
        pedido.adcionarItem(macBookPro, 1);
        pedido.adcionarItem(magicBoard, 2);
        pedido.adcionarItem(magicMouse, 1);
        Assertions.assertEquals(new BigDecimal(14000), pedido.valorTotal());
    }
}
