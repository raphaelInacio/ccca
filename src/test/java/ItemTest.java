import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void deveCriarCalcularVolume() {
        Item guitarra = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 100.0, 30.0, 10.0, 3.0);
        Item geladeira = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 200.0, 100.0, 50.0, 40.0);
        Item camera = new Item(1L, "Camera", BigDecimal.valueOf(1000), 20.0, 15.0, 10.0, 1.0);
        assertEquals(0.03, guitarra.getVolume());
        assertEquals(0.003, camera.getVolume());
        assertEquals(1, geladeira.getVolume());
    }

    @Test
    void deveCalcularDensidade() {
        Item guitarra = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 100.0, 30.0, 10.0, 3.0);
        Item geladeira = new Item(1L, "Guitarra", BigDecimal.valueOf(1000), 200.0, 100.0, 50.0, 40.0);
        Item camera = new Item(1L, "Camera", BigDecimal.valueOf(1000), 20.0, 15.0, 10.0, 1.0);
        assertEquals(100, guitarra.getDensidade());
        assertEquals(333, camera.getDensidade());
        assertEquals(40, geladeira.getDensidade());
    }

}