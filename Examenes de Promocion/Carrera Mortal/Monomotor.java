import java.util.TreeSet;

class Monomotor extends Vehiculo {
    private static Integer VIDA = 2000;
    private static Integer DEFENSA = 500;

    public Monomotor(String nombre) {
        super(nombre, VIDA, DEFENSA);
    }

    @Override
    public Integer getCantidadMotores() {
        return 1;
    }

    
    /**
     * Imprime la lista de armamento disponible del monomotor.
     * Dicha lista se encuentra ordenada de acuerdo al puntaje de cada monomotor (menor a mayor)
     * Si no se encuentra ningún armamento se imprimirá el siguiente error:
     *      El vehículo no posee ningún armamento
     * Ayuda: La clase Armamento implementa la interfaz Comparable
     * Ej: 
     *      Pincha Ruedas puntaje: 20
     *      Lanza Misiles puntaje: 50
     *      Defensa Frontal puntaje: 100
     * @return
     */
    public void imprimirArmamento() {
        final TreeSet<Armamento> set = new TreeSet<Armamento>(this.getArmamento());
        if (set.size() > 0) {
            set.forEach(iterator -> System.out.println(iterator + " puntaje: " + iterator.getPuntaje()));
        } else {
            System.out.println("El vehículo no posee ningún armamento");
        }
        
    }
    
}
