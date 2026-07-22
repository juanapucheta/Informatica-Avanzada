import java.util.*;
// Codigo armado por Juana Pucheta. Puntaje 40 / 40

public class Heroe extends Personaje implements Luchador {

    private static final int ATAQUE = 20;
    private static final int ENERGIA = 100;
    private static final int INCREMENTO_ENERGIA = 10;
    private static final int INCREMENTO_ATAQUE = 5;
    private Faccion faccion;

    /**
     * Crea una nueva instancia de Heroe, con el nivel de ataque y energia
     * por defecto (para Heroe)
     * @param nombre Nombre del Heroe
     * @param faccion Faccion a la cual pertenece
     * 
     */
    Heroe(String nombre, Faccion faccion) {
        super(ATAQUE, ENERGIA, nombre);
        this.faccion = faccion;        
    }

    /**
     * El heroe solo puede atacar a objetivos cercanos (ver método obtenerPersonajesCercanos clase Mapa).
     * Debe ser un villano o bien un Heroe de una faccion diferente a la del heroe.
     * Los danios se hacen mediante el metodo RecibirGolpe con el nivel de ataque propio.
     */
    @Override
    public void atacar() {
        List<Personaje> personajesCercanos = super.mapa.obtenerPersonajesCercanos(this);
        
        for(Personaje p : personajesCercanos){
            if(p instanceof Villano){
                Villano v = (Villano) p;
                v.recibirGolpe(this.ATAQUE);
            }
            
            if(p instanceof Heroe){
                Heroe h = (Heroe) p;
                if(h.getFaccion() != this.getFaccion()){
                    h.recibirGolpe(this.ATAQUE);
                }
            }
        }   
    }

    /**
     * Disminuye la vida del Heroe por el valor del danio
     */
    @Override
    public void recibirGolpe(int danio) {
        super.incrementarEnergia(-danio);
    }

    /**
     * Aumenta su vida de acuerdo a la variable INCREMENTO_VIDA
     * y su ataque de acuerdo a la variable INCREMENTO_ATAQUE
     */
    @Override
    public void subirNivel() {
        super.incrementarAtaque(INCREMENTO_ATAQUE);
        
        // No existe la variable INCREMENTO_VIDA.
        super.incrementarEnergia(INCREMENTO_ENERGIA);
    }

    /**
     * Mueve UNA VEZ a la primera posicion disponible en el siguiente orden
     * 1. ARRIBA
     * 2. ABAJO
     * 3. DERECHA
     * 4. IZQUIERDA
     * Si ningun movimiento esta disponible el heroe se queda quieto
     * AYUDAS:
     * - Las direcciones se pueden recorrer como una lista en ese 
     * oreden utilizando Direccion.values()
     * - Metodo realizarMovimiento de Mapa para comprobar que el
     * movimiento sea legal
     */
    @Override
    public void mover() {
        for(Direccion d : Direccion.values()){
            if(super.mapa.moverPersonajeEnDireccion(this, d)){
                super.getPosicion().nuevaPosicion(d);
            }
        }
    }

    /**
     * Devuelve la faccion del Heroe
     * @return
     */
    public Faccion getFaccion(){
        return this.faccion;
    }
}
