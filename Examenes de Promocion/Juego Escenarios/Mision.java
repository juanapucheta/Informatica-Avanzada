public abstract class Mision {
    private String nombre;
    private Integer nivelRequerido;

    /**
     * Crea una nueva mision con su nombre y el requerimiento de nivel
     * necesario para realizarla
     *
     * @param nombre El nombre de la mision
     * @param nivelRequerido El nivel requerido para participar de la mision
     */
    public Mision(String nombre, Integer nivelRequerido) {
        this.nombre = nombre;
        this.nivelRequerido = nivelRequerido;
    }

    public abstract Boolean validarCumplimiento(Personaje p) ;

    public String getNombre() {
        return nombre;
    }

    public Integer getNivelRequerido() {
        return nivelRequerido;
    }
}