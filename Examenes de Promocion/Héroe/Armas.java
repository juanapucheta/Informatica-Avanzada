/** Modela cualquier tipo de arma. */

public abstract class Armas extends Objetos {
    private Integer alcance;
    private Integer danio;

    /**
     * El uso de un arma puede desgastarla o consumir municiones,
     * por eso la implementación depende del arma
     * @throws ArmaDescargadaException En caso que no haya municiones suficientes
     */
    public abstract void Atacar () throws ArmaDescargadaException;

    /**
     * No todas las armas se puede recargar. En caso de que el arma
     * sea recargable, debe sobreescribir este método.
     * @param obj La munición a recargar
     * @throws ArmaNoRecargableException En caso de aplicarlo sobre un
     *              arma no recargable
      */
    public Objetos RecargarArma (Objetos obj) throws ArmaNoRecargableException, CombinacionNoPermitidaException {
        throw new ArmaNoRecargableException(toString() + ": No es recargable");
    }

    public Integer getAlcance() {
        return alcance;
    }

    public void setAlcance(Integer alcance) {
        this.alcance = alcance;
    }

    public Integer getDanio() {
        return danio;
    }

    public void setDanio(Integer danio) {
        this.danio = danio;
    }

}
