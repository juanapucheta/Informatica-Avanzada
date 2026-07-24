El sistema modela el mecanismo de tarifacion y lectura de los
medidores de una empresa proveedora de Energia.

La Empresa posee Clientes, cada uno de los cuales tiene asociado un
Medidor. La clase Empresa posee metodos para dar de alta y baja
Clientes, incorporar o dar de baja Medidores, y asociar y separar
Clientes de Medidores.

Los Clientes tienen una lista de Lecturas realizadas. La clase Cliente
permite registrar Lecturas del Medidor asociado, obtener el consumo en
un periodo determinado, y agregar o remover un Medidor.

Las Lecturas tienen fecha y valor de consumo medido.

Los Medidores pueden ser Monofasicos o Trifasicos, y permiten
consultar el consumo acumulado. Cada Medidor tiene asociada una
Ubicacion.

Finalmente, la clase Utils implementa metodos para determinar si una
Lectura es valida dentro de una serie de Lecturas, y metodos para
obtener Lecturas dentro de un rango de fechas definido.

-----------------------------------------------------------------------

1) Completar el constructor de la clase CoordenadaGPS de
   acuerdo a la documentacion

   a. public CoordenadaGPS (double latitud, double longitud)

--
2) Implementar la clase MedidorTrifasico, tal que:

   a. Extienda de la clase Medidor, e implemente los
      constructores requeridos

   b. Implemente el metodo abstracto de la clase padre:
      public abstract TipoMedidor getTipoMedidor();

   c. Sobreescriba el metodo toString(), tal que agregue
      "_<tipoDeMedidor>" a la implementacion original de
      toString() en la clase padre.
      (ej.: "SN_12345_MONOFASICO" o "SN_343423_TRIFASICO")

--
3) Completar la implementacion del constructor y los metodos
   incompletos de la clase Cliente

   a. public Cliente (String nombre)

   b. public boolean asociarMedidor(Medidor m)

   c. public void removerMedidor()

   d. public String toString()

NOTA: Puede hacer uso de los metodos de la clase Utils para
      facilitar la implementacion del siguiente metodo

   e. public int consumoPeriodo (Fecha desde, Fecha hasta)

--
4) Completar la implementacion de los metodos incompletos de la clase
   Empresa

   a. public Medidor nuevoMedidor(TipoMedidor tipo, CoordenadaGPS pos)

   b. public boolean bajaMedidor(int serialNumber)

   c. public void asociarMedidorACliente(Cliente c, Medidor m)

   d. public void disociarMedidorDeCliente (Cliente c)

