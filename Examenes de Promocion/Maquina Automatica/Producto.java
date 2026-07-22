/*
 * Recetas de la maquina
 */
public enum Producto {
	EXPRESO, CAPUCHINO, CORTADO, LATTE, CHOCOLATE, SOLUBLE;

	private int precio;
	private Receta receta;
	static final int PRECIO_POR_DEFECTO = 20;
	
	private Producto(){
		precio = Producto.PRECIO_POR_DEFECTO;
		receta = null;
	}
	public void setPrecio(int precio){
		if (precio<0)
			throw new IllegalArgumentException();
		this.precio=precio;
	}
	public int getPrecio(){
		return precio;
	}
	public void setReceta(Receta r){
		receta = r;
	}
	public Receta getReceta(){
		return receta;
	}
}
