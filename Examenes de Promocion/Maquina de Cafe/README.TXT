El proyecto representa parte de un sistema de maquina de cafe.

La maquina posee Recipientes que contienen los Ingredientes necesarios
para preparar diferentes tipos de Producto. Ademas, se puede
configurar para despachar diferentes productos. Cada producto tiene
asociada una Receta. Pueden incluirse ademas algunos extras para el cafe.

1. Complete los métodos de la clase Cafe, de acuerdo a la documentación en la clase

public void agregarExtra(Extra extra);
public List<Extra> obtenerExtras();
public List<Ingrediente> obtenerIngredientes(Map<TipoProducto, Receta> recetas);
    
2. Complete los métodos de la clase MaquinaDeCafe, de acuerdo a la documentación en la clase

public Cafe prepararProducto(TipoProducto seleccion);
public Recipiente getRecipiente (Ingrediente ingrediente);
public void agregarReceta (Receta r, TipoProducto p);
public void setSeleccion(TipoProducto seleccion);
Implementar los metodos de la interfaz MaquinaDeEstados en la clase MaquinaDeCafe.
  + encender:
     - lanza IllegalStateException si la maquina no esta APAGADA
     - cambia el Estado de la maquina a LISTO
     - establece la seleccion de producto en null
  + apagar:
     - lanza IllegalStateException si la maquina esta OPERANDO
     - cambia el Estado de la maquina a APAGADO.
  + operar:
     - verifica si puede despachar el producto seleccionado
     - lanza IllegalStateException si la maquina no esta LISTA
     - despacha el producto seleccionado
     - cambia el Estado de la maquina a OPERANDO
     - incrementa la cuenta de productos despachados
  + restablecer:
     - cambia el Estado de la maquina a LISTO
     - establece la seleccion de producto en null    
  + mantener:
     - lanza IllegalStateException si la maquina no esta LISTA
     - cambia el Estado de la maquina a MANTENIMIENTO

3. Complete los métodos de la clase Receta, de acuerdo a la documentación en la clase

public void agregarIngrediente(Ingrediente ing, Integer cantidad);
public int volumenTotalReceta()


4. Genere la clase Silo que extiende de Recipiente y sus metodos, de acuerdo a la documentación en la superclase. Considere los casos cuando no hay ingrediente o capacidad es mayor a capacidad máxima o negativa. Debe lanzar IlegalArgumentException

public Silo (Ingrediente ingredienteAlmacenado, int capacidadMaxima);
public Silo (Ingrediente ingredienteAlmacenado);
public Ingrediente getTipoIngredienteAlmacenado();

