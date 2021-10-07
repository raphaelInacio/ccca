import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void deveCriarCalcularVolume() {
        Item guitarra = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 100L, 30L, 10L, 3L);
        Item geladeira = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 200L, 100L, 50L, 40L);
        assertEquals(0.03, guitarra.getVolume());
        assertEquals(1, geladeira.getVolume());
    }

    @Test
    void deveCalcularDensidade() {
        Item guitarra = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 100L, 30L, 10L, 3L);
        Item geladeira = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 200L, 100L, 50L, 40L);
        assertEquals(100, guitarra.getDensidade());
        assertEquals(40, geladeira.getDensidade());
    }

}