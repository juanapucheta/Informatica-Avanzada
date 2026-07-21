/** Modela un tipo de flechas. Siempre son un grupo de flechas. */

class Flechas extends Objetos {
    private Integer danio;
    private Integer cantidad;

    /** Crea un conjunto de flechas genéricas */
    public Flechas() {
        setPeso(1);
        setCantidad(10);
    }

    /** Descuenta una flecha del total.
     *  @throws ArmaDescargadaException Cuando no hay más flechas.
      */
    public void UsarFlecha () throws ArmaDescargadaException {
        if (cantidad == 0) {
            throw new ArmaDescargadaException("Flechas: No hay mas flechas");
        }
        cantidad -= 1;
    }

    public Integer getDanio() {
        return danio;
    }

    public void setDanio(Integer danio) {
        this.danio = danio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}