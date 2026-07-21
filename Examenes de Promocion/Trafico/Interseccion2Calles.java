/**
 * Implementacion de la Interfaz de Interseccion para el caso de una esquina de solo dos calles
 */
public class Interseccion2Calles implements InterseccionInterface{

    private Calle calle_a,calle_b;
    private Semaforo sem_calle_a, sem_calle_b;
    private Integer altura_en_a, altura_en_b;

    public Interseccion2Calles(Calle a, Calle b, Integer altura_en_a, Integer altura_en_b) throws IllegalArgumentException{
        this.calle_a = a;
        this.calle_b = b;

        if (altura_en_a > calle_a.get_longitud() || altura_en_b > calle_b.get_longitud() ){
            throw new IllegalArgumentException("La altura de la interseccion debe ser menor a la longitud de la calle");
        }
        // trafico.Semaforo A va a controlar el estado del trafico.Semaforo B
        this.sem_calle_a = new Semaforo(ESTADOS.ROJO);
        this.sem_calle_b = new Semaforo(ESTADOS.VERDE);

        this.altura_en_a = altura_en_a;
        this.altura_en_b = altura_en_b;

        System.out.println(String.format("trafico.intersecciones.Interseccion2Calles - Entre: %s y %s en: (%d,%d)", this.calle_a, this.calle_b,
                altura_en_a, altura_en_b) );
    }

    @Override
    public void registrar_interseccion(){
        // Registro la interseccion en las calles
        this.calle_a.agregar_interseccion(this);
        this.calle_b.agregar_interseccion(this);
    }

    @Override
    public boolean get_paso(Calle calle) throws CalleIncorrectaException {
        if(!calle.equals(calle_a) && !calle.equals(calle_b)){
            throw new CalleIncorrectaException();
        }

        if (calle.equals(calle_a) && sem_calle_a.esta_disponible()){
            return true;
        }
        else {
            return calle.equals(calle_b) && sem_calle_b.esta_disponible();
        }
    }

    @Override
    public Integer get_altura_calle(Calle calle) throws CalleIncorrectaException {
        if (calle.equals(calle_a)){
            return altura_en_a;
        }
        else if (calle.equals(calle_b)){
            return altura_en_b;
        }
        else{
            throw new CalleIncorrectaException();
        }
    }

    /**
     * Invierte el estado de los dos semáforos pertenecientes a la intersección
     * Toma la exclusion mutua del Mapa para sincronizar con la circulacion de los autos
     */
    public void next_estado_semaforo(){
        if((sem_calle_a.get_estado() == ESTADOS.VERDE) && (sem_calle_b.get_estado() == ESTADOS.ROJO)){
            sem_calle_a.set_estado(ESTADOS.ROJO);
            sem_calle_b.set_estado(ESTADOS.VERDE);
        }
        else{
            sem_calle_b.set_estado(ESTADOS.ROJO);
            sem_calle_a.set_estado(ESTADOS.VERDE);
        }
        System.out.println(String.format("El semaforo de la interseccion %s cambio de estado", this));
        System.out.println(String.format("%s para %s", sem_calle_a.get_estado(), calle_a));
        System.out.println(String.format("%s para %s", sem_calle_b.get_estado(), calle_b));

    }


    public String toString(){
        return String.format("%s y %s", calle_a, calle_b);
    }
}
