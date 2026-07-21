class DefensaFrontal extends Armamento {
    private static Integer DEFENSA = 100;

    public DefensaFrontal() {
        super(TipoArmamento.DEFENSIVO, DEFENSA);
    }

    @Override
    public void usar(Vehiculo v) {
        System.out.print("Usando defensa frontal: ");
        super.usar(v);
        v.aumentarDefensa(DEFENSA);
    }

    @Override
    public String toString() {
        return "Defensa Frontal";
    }
}
