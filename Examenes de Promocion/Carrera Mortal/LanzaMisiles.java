class LanzaMisiles extends Armamento {
    private static Integer ATAQUE = 50;

    public LanzaMisiles() {
        super(TipoArmamento.OFENSIVO, ATAQUE);
    }

    @Override
    public void usar(Vehiculo v) {
        System.out.print("Atacando con Lanza Misiles: ");
        super.usar(v);
        v.recibirAtaque(ATAQUE);
    }

    @Override
    public String toString() {
        return "Lanza Misiles";
    }
}
