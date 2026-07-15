public enum TipoElemento {
    ARMA_BLANCA("Arma"),
    ARMA_FUEGO("Arma"),
    ARMA_FLECHAS("Arma"),
    MUNICION("Municion"),
    LIQUIDO("Liquido"),
    RECIPIENTE("Recipiente"),
    INGREDIENTE("Ingrediente"),
    ALIMENTO("Alimento"),
    FIJO("Fijo");

    private final String descripcion;

    private TipoElemento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
