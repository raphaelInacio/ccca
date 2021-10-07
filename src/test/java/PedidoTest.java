import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoTest {

    @Test
    void naoDeveCriarUmPedidoComCPFInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Pedido("111.111.111-11", LocalDate.now()));
    }

    @Test
    void deveCriarUmPedidoComTresItens() {
        Pedido pedido = new Pedido("326.873.088-46", LocalDate.now());
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
        Cupom descontoDezPorcento = new Cupom("VALE10", 10, LocalDate.now());
        Pedido pedido = new Pedido("326.873.088-46", LocalDate.now());
        Item macBookPro = new Item(1L, "Mac book pro", new BigDecimal(10000));
        Item magicMouse = new Item(2L, "Magic Mouse", new BigDecimal(1000));
        Item magicBoard = new Item(3L, "Magic board", new BigDecimal(1500));
        pedido.adcionarItem(macBookPro, 1);
        pedido.adcionarItem(magicBoard, 1);
        pedido.adcionarItem(magicMouse, 1);
        pedido.adicionarCupom(descontoDezPorcento);
        Assertions.assertEquals(new BigDecimal(11250), pedido.calcularValorDoPedido());
    }

    @Test
    void quandoNaoInformadoCupomDeDescontoDeveSerAplicadoValorCheio() {
        Pedido pedido = new Pedido("326.873.088-46", LocalDate.now());
        Item macBookPro = new Item(1L, "Mac book pro", new BigDecimal(10000));
        Item magicMouse = new Item(2L, "Magic Mouse", new BigDecimal(1000));
        Item magicBoard = new Item(3L, "Magic board", new BigDecimal(1500));
        pedido.adcionarItem(macBookPro, 1);
        pedido.adcionarItem(magicBoard, 2);
        pedido.adcionarItem(magicMouse, 1);
        Assertions.assertEquals(new BigDecimal(14000), pedido.calcularValorDoPedido());
    }

    @Test
    void naoDeveAplicarDescontoEmUmCupomExpirado() {
        Cupom descontoDezPorcentoExpirado = new Cupom("VALE10", 10, LocalDate.now().minusDays(1L));
        Pedido pedido = new Pedido("326.873.088-46", LocalDate.now());
        Item macBookPro = new Item(1L, "Mac book pro", new BigDecimal(10000));
        Item magicMouse = new Item(2L, "Magic Mouse", new BigDecimal(1000));
        Item magicBoard = new Item(3L, "Magic board", new BigDecimal(1500));
        pedido.adcionarItem(macBookPro, 1);
        pedido.adcionarItem(magicBoard, 2);
        pedido.adcionarItem(magicMouse, 1);
        pedido.adicionarCupom(descontoDezPorcentoExpirado);
        Assertions.assertEquals(new BigDecimal(14000), pedido.calcularValorDoPedido());
    }

    @Test
    void deveCalcularFrete() {
        Item geladeira = new Item(1L, "Geladeira", BigDecimal.valueOf(1000), 200.0, 100.0, 50.0, 40.0);
        Pedido pedido = new Pedido("326.873.088-46", LocalDate.now());
        pedido.adcionarItem(geladeira, 1);
        Assertions.assertEquals(400.00, pedido.obterFrete());
    }

    @Test
    void deveCalcularFreteMinimo() {
        Item camera = new Item(1L, "Camera", BigDecimal.valueOf(1000), 20.0, 15.0, 10.0, 1.0);
        Pedido pedido = new Pedido("326.873.088-46", LocalDate.now());
        pedido.adcionarItem(camera, 1);
        Assertions.assertEquals(10.00, pedido.obterFrete());
    }
}
