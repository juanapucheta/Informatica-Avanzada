/**
 * Los insumos son componentes capaz de entregar
 * energia. Las interfaces están orientadas
 * a poder consultar los niveles y modificarlos
 */
interface Consumible {
    /**
     * Devuelve el nivel de energia del insumo,  de manera porcentual (0 a 100%)
     *  IMPORTANTE: si bien la capacidad actual y máxima son Integer, el
     *  cálculo debe hacerse en Double y convertirlo en entero nuevamente para
     *  retornar el nivel de energia.
     *  (De lo contrario se producirán errores en los cálculos)
     * @return Nivel de energía en porcentaje.
     */
    public Integer getNivelDeEnergia();

    /**
     * La energía se consume en Watts por hora, esto afectará
     * el nivel de energía del insumo dependiendo de la
     * capacidad de cada insumo. Si la cantidad que se pretende consumir
     * es mayor a la disponible se arroja un IllegalArgumentException 
     * @param wattsHora Cantidad de energia a consumir.
     * @throws IllegalArgumentException Si la cantidad que se pretende consumir
     * es mayor a la disponible.
     */
    public void consumirEnergia(Integer wattsHora) throws   IllegalArgumentException;

    /**
     * La energía se puede recargar, de la misma forma en que se consume.
     * En caso de que la cantidad de energía suministrada sea mayor a la 
     * capacidad del insumo, la energía del insumo quedará en capacidad máxima
     * (SIN arrojar excepción)
     * Puede arrojar un IllegalArgumentException si se introduce valores de
     * energía negativos 
     * @param wattsHora La cantidad de energía a recargar.
     * @throws IllegalArgumentException Si se introduce un valor de energía negativo.
     */
    public void recargarEnergia(Integer wattsHora);
}
