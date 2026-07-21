class Bateria extends Insumo {
    private static Integer CAPACIDAD_BATERIA = 3000; // Capacidad en [mAh]
    private Integer voltajeBateria;

    /***
     * En el caso de la bateria la capacidad suele determinarse en mili Ampere por
     * hora [mAh] Esta se relaciona con la unidad Wh a través de la tensión que entrega la
     * batería Ej: 3000 mAh * 5 V = 11.100 mWh = 11.1 Wh
     * 
     * @param voltaje
     */
    Bateria(Integer voltaje) {
        super((Bateria.CAPACIDAD_BATERIA * voltaje / 1000));
        this.setVoltajeBateria(voltaje);
    }

    /**
     * @return retorna la tensión de trabajo de la bateria
     */
    public Integer getVoltajeBateria() {
        return voltajeBateria;
    }

    /**
     * Cambia la tensión de trabajo de la bateria
     * Se debe renovar el cálculo de la capacidad máxima descripta en el constructor
     * @param voltajeBateria nuevo voltage de la bateria
     * */
    public void setVoltajeBateria(Integer voltajeBateria) {
        this.voltajeBateria = voltajeBateria;
        this.setMaxCapacidad((Bateria.CAPACIDAD_BATERIA * voltajeBateria / 1000));
    }
}



















