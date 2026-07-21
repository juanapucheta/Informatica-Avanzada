import java.util.TreeSet;

class MultiMotor extends Vehiculo {
    private static Integer VIDA = 1000;
    private static Integer DEFENSA = 1000;

    public MultiMotor(String nombre) {
        super(nombre, VIDA, DEFENSA);
    }

    @Override
    public Integer getCantidadMotores() {
        return 4;
    }
    
    /**
     * Imprime la lista de armamento disponible del multimotor.
     * Dicha lista se encuentra ordenada alfabéticamente de acuerdo al nombre de cada 
     * armamento
     * Ayuda: Utilizar los nombres de los armamentos en vez del objeto, ya que Armamento
     * utiliza la clase Comparable pero los ordenada de acuerdo al puntaje
     * Ej: 
     *      Defensa Frontal puntaje: 100
     *      Lanza Misiles puntaje: 50
     *      Pincha Ruedas puntaje: 20
     * @return
     */
    public void imprimirArmamento() {
        TreeSet<String> set = new TreeSet<String>();
        for (Armamento element : this.getArmamento()) {
            set.add(element.toString() + " puntaje: " + element.getPuntaje());
        }
        set.forEach(iterator -> System.out.println(iterator));
    }
    
}
