import java.util.List;

/**
 * Write a description of class DescodificadorDeMensaje here.
 * 
 * @author (Lescano José, Lombardi Santiago) 
 * @version (a version number or a date)
 */
public class DecodificadorMensajes {

    public void decodificarMensaje(Mensaje mensaje, int[] codigo) {
        List<String> lineas = mensaje.obtenerLineas();

        for (int i = 0; i < lineas.size(); i++) {
            StringBuilder decodificada = new StringBuilder();
            String linea = lineas.get(i);
            for (int j = 0; j < linea.length(); j++) {
                int desplazamiento = codigo[j % codigo.length];
                char nuevoCaracter = (char) ((linea.charAt(j) - desplazamiento + 128) % 128);
                decodificada.append(nuevoCaracter);
            }
            lineas.set(i, decodificada.toString());
        }
    }

    public String desencriptarCadena(String str, int[] codigo) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int desplazamiento = codigo[i % codigo.length];
            char nuevoCaracter = (char) ((str.charAt(i) - desplazamiento + 128) % 128);
            resultado.append(nuevoCaracter);
        }
        return resultado.toString();
    }
}
