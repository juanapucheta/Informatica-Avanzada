1. Implmentar los métodos requeridos en la clase Medidor que implementa Reseteable

2. Implementar las clases MedidorComercial y MedidorIndustrial, tal que
	a. Extiendan de la clase Medidor, 
	b. implementando metodos abstractos 
	c. implemente los constructores requeridos
	d. sobreescriba el metodo toString(), tal que agregue "_<tipoDeMedidor" a la implementación original de toString() de la clase padre.

2. Completar la implementación del constructor y los metodos incompletos de la clase Cliente
	public Cliente (String nombre)
	public boolean asociarMedidor(Medidor m)
	public void removerMedidor()
	public String toString()
NOTA: Puede hacer uso de los metodos de la clase Utils para facilitar la implementación de los siguientes métodos
	public int consumoPeriodo (Fecha desde, Fecha hasta)
	public void registrarNuevaLectura (Fecha f) throws LecturaInconsistenteException
	
3. Completar el constructor de la clase CoordenadaGPS de acuerdo a la documentacion

4. Completar la implementación del los metodos incompletos de la clase Empresa
	public Cliente getCliente(String nombre)
	public Cliente nuevoCliente (String nombre)
	public Medidor nuevoMedidor(TipoMedidor tipo, CoordenadaGPS pos)
	public boolean bajaCliente(String nombreCliente)
	public boolean bajaMedidor(int serialNumber)
	public void asociarMedidorACliente(Cliente c, Medidor m)
	public void disociarMedidorDeCliente (Cliente c)
	
5. Implemente los metodos de la clase Utils
	public static boolean validarLectura(Lectura lectura, List<Lectura> lista)
	public static List<Lectura> filtrarLecturasPorFecha (List<Lectura> lecturas, Fecha desde, Fecha hasta)