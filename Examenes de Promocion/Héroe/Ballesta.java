/** Modela una ballesta. */

public class Ballesta extends Armas {
    private Flechas flecha;

    /**
     * La ballesta se inicia con 10 flechas de madera. Las flechas de madera
     * tienen peso 1 y daño 1.
     */
    public Ballesta() {
        setPeso(5);
        setAlcance(5);
        setDanio(0);
    }

    public Flechas getFlechas() {
        return flecha;
    }

    /**
     * Carga las nuevas flechas en la ballesta.
     * Debe actualizarse el daño a producir. 
     * @param flecha Las flechas a cargar
     */
    public void setFlechas(Flechas flecha) {
        this.flecha = flecha;
        setDanio(flecha.getDanio());
    }

    /**
     * Ejecuta el ataque descargando una flecha de la ballesta. Si no hay más
     * flechas lanza ArmaDescargadaException.
     * 
     * @throws ArmaDescargadaException Cuando no hay flechas para disparar.
     */
    public void Atacar() throws ArmaDescargadaException {
        if (flecha == null) {
            throw new ArmaDescargadaException("");
        }
        else {
            flecha.UsarFlecha();
        }
    }

    /**
     * Carga la ballesta con las flechas indicadas. Si la ballesta tiene
     * flechas, las devuelve a la bolsa.
     * 
     * @param obj Las flechas a cargar
     * @return Las flechas que estaban en la ballesta
     */
    @Override
    public Objetos RecargarArma (Objetos obj) throws ArmaNoRecargableException, CombinacionNoPermitidaException {
        Flechas temp = flecha;
        if (obj instanceof Flechas) {
            if (flecha == null || flecha.getCantidad() == 0) {
                flecha = (Flechas) obj;
            }
        }
        else {
            throw new CombinacionNoPermitidaException("");
        }
        return temp;
    }
}

