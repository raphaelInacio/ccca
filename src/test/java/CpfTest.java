import br.com.ccca.domain.entity.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {
    @Test
    void deveValidarUmCPF() {
        assertNotNull(new Cpf("326.873.088-46"));
    }

    @Test
    void deveLancarErroAoVerificarUmCpfinvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Cpf("111.111.111-11"));
    }
}