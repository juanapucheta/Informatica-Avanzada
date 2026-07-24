
public class Elemento {
    private String nombre;

    public Elemento () {
        nombre = "Elemento mal construido";
    }

    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
