/**
 * Clase de prueba que utiliza Registro, Libreta de Contactos y Visor.
 * 
 * 
 *
 */
public class Telefono {
	
	private Registro reg;
	private LibretaDeContactos cont;
	private Formateable visor;
	
	public Telefono (){
		
	}

	public Registro getReg() {
		return reg;
	}

	public void setReg(Registro reg) {
		this.reg = reg;
	}

	public LibretaDeContactos getCont() {
		return cont;
	}

	public void setCont(LibretaDeContactos cont) {
		this.cont = cont;
	}

	public Formateable getVisor() {
		return visor;
	}

	public void setVisor(Formateable visor) {
		this.visor = visor;
	}


	public void mostrarRegistro(){
		System.out.println(visor.convertirListaComoString(reg.getRegistroCompleto()));
	}
	public void mostrarRegistroAmibagle(){
		System.out.println(visor.convertirListaComoStringAmigable(reg.getRegistroCompleto(), cont));
	}
	public void mostrarEstadisticasTotales(){
		try {
			System.out.println(visor.convertirMapaEstadisticaComoString(reg.getMapaDeEstadisticasDelRegistroCompleto()));
		} catch (Exception e) {
			
		}
	}

	public void mostrarLlamadasPorTipo(TipoDeLlamada tipo){
		System.out.println(visor.convertirListaComoString(reg.getLlamadasPorTipo(tipo)));
	}
	public void mostrarDuracionTotalLlamadas(){
		System.out.println(reg.getDuracionTotalLlamadasDelRegistro());
	}
}
