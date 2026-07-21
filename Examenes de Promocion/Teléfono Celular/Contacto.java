import java.util.ArrayList;
import java.util.List;


public class Contacto {
	private String nombre;
	private String apellido;
	private List <String> mails;
	private String numeroTelefonico;
	
	public Contacto (String nombre, String apellido, String numero){
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroTelefonico = numero;		
		mails = new ArrayList<String>();
	}	
	
	
	public void agregarMail (String mail){
		if (!mails.contains(mail)){
			mails.add(mail);					
		}
	}
	
	public void borrarMail (String mail){
		if (mails.contains(mail)){
			mails.remove(mail);					
		}
	}
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public String getNumerotelefonico() {
		return numeroTelefonico;
	}

	public List<String> getMails() {
		return mails;
	}
	
	public String toString (){
		StringBuilder sb = new StringBuilder();
		sb.append(apellido.toUpperCase());
		sb.append(", ");
		sb.append(nombre.toLowerCase());
		sb.append("(");
		sb.append(numeroTelefonico);
		sb.append(") ");
		for (String s:mails){
			sb.append (s);
			sb.append (";");
		}
		return sb.toString();
	}
}
