1. Implemente las clases Cuadrangular, Octogonal y TorneoRegular, tal que extiendan de Torneo. 
La cantidad máxima de equipos pormitidos en cada torneo es 4, 8 y 20 respectivamente.

2. Implemente la clase Profesional, tal que implemente la interfaz Desempenio. 
En esta implementación cada victoria suma 3 puntos, empate 2 puntos y derrota 1 punto-

3. Implemente los siguietnes metodos de la clase Equipo (puede agregar las variables de instancia o clase que considere)
	public boolean equals (Object o)
	public Equipo (String nombre)
	public String getNombre()
	 
4. Implemente el constructor y los siguientes metodos de la clase PArtido según la documentación de la clase
	public Partido (Equipo local, Equipo visita)
	public Equipo getEquipoLocal()
	public Equipo getEquipoVisitante()
	public Resultado getResultado() 
	public void setResultado(Resultado resultado)
	public boolean disputado() 
	public String toString()
	
5. Implemente el constructor y los siguientes metodos de la clase Partido según la documentación de la clase

	public Torneo (String nombre)
	public void iniciarTorneo()
	public boolean addEquipo(Equipo e)
	public void addPartido (Partido p)	
	public int partidosDisputados()
	public int cantidadDeEquipos()
	public int cantidadDePartidos()
	public String toString()
	public Map<Equipo,Desempenio> getPosiciones()	