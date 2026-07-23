public enum Ubicacion {
    ALA_NORTE, ALA_SUR, ALA_CENTRO;

    @Override
    public String toString() {
        return name().replace("_", " ").toLowerCase();
    }
}