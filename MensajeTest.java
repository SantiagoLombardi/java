

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
/**
 * The test class MensajeTest.
 *
 * @author  (Lescano José, Lombardi Santiago)
 * @version (a version number or a date)
 */

public class MensajeTest {
    private Mensaje mensaje;

    @BeforeEach
    public void setUp() {
        mensaje = new Mensaje();
    }

    @Test
    public void agregarLineaValida() {
        mensaje.agregarLinea(0, "Hello, how are you?");
        List<String> lineas = mensaje.obtenerLineas();
        assertEquals(1, lineas.size());
        assertEquals("Hello, how are you?", lineas.get(0));
    }

    @Test
    public void agregarLineaInvalida() {
        mensaje.agregarLinea(1, "Hello, how are you?");
        List<String> lineas = mensaje.obtenerLineas();
        assertEquals(0, lineas.size());
    }

    @Test
    public void mensajeIgual() {
        mensaje.agregarLinea(0, "Hello, how are you?");
        Mensaje otroMensaje = new Mensaje();
        otroMensaje.agregarLinea(0, "Hello, how are you?");
        assertTrue(mensaje.equals(otroMensaje));
    }

    @Test
    public void mensajeDiferente() {
        mensaje.agregarLinea(0, "Hello, how are you?");
        Mensaje otroMensaje = new Mensaje();
        otroMensaje.agregarLinea(0, "Bye");
        assertFalse(mensaje.equals(otroMensaje));
    }
}
