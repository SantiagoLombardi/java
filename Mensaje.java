import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Write a description of class Mensaje here.
 * 
 * @author (Lescano José, Lombardi Santiago) 
 * @version (a version number or a date)
 */


public class Mensaje {
    private List<String> listaLineas;

    public Mensaje() {
        this.listaLineas = new ArrayList<>();
    }

    public void agregarLinea(int pos, String linea) {
        if (pos >= 0 && pos <= listaLineas.size()) {
            listaLineas.add(pos, linea);
        } else {
            System.err.println("Posición inválida");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mensaje otro = (Mensaje) obj;
        return Objects.equals(listaLineas, otro.listaLineas);
    }

    public String obtenerPrimeraLinea() {
        if (!listaLineas.isEmpty()) {
            return listaLineas.get(0);
        }
        return "";
    }

    public List<String> obtenerLineas() {
        return listaLineas;
    }
}

