import java.util.List;

/**
 * Write a description of class CodificadorDeMensaje here.
 * 
 * @author (Lescano José, Lombardi Santiago) 
 * @version (a version number or a date)
 */
public class CodificadorMensajes {

    public int[] generarCodigoEncripcion(String str) {
        int[] codigo = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            codigo[i] = str.charAt(i);
        }
        return codigo;
    }

    public void codificarMensaje(Mensaje mensaje) {
        String primeraLinea = mensaje.obtenerPrimeraLinea();
        int[] codigo = generarCodigoEncripcion(primeraLinea);
        List<String> lineas = mensaje.obtenerLineas();

        for (int i = 0; i < lineas.size(); i++) {
            StringBuilder codificada = new StringBuilder();
            String linea = lineas.get(i);
            for (int j = 0; j < linea.length(); j++) {
                int desplazamiento = codigo[j % codigo.length];
                char nuevoCaracter = (char) ((linea.charAt(j) + desplazamiento) % 128);
                codificada.append(nuevoCaracter);
            }
            lineas.set(i, codificada.toString());
        }
    }
}
