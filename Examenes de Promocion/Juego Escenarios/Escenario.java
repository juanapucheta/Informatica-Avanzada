
import java.util.ArrayList;

public abstract class Escenario  {
    private String nombre;
    private Integer capacidad;
    private ArrayList<Elemento> elementos;
    private ArrayList<Personaje> visitantes;

    public Escenario () {
        nombre = "Escenario no usable";
    }

    public Escenario(String nombre, Integer capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.elementos = new ArrayList<>();
        this.visitantes = new ArrayList<>();
    }

    public abstract void visitar(PersonajeJugador p);

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos (ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public ArrayList<Personaje> getVisitantes() {
        return visitantes;
    }

    public Integer getCapacidad() {
        return capacidad;
    }
}
