

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class prueba.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class prueba
{
    private Cliente cliente1;
    private Fecha fecha1;
    private Lectura lectura1;
    private MedidorComercial med1;
    private CoordenadaGPS coord1;
    private Empresa empresa1;
    /**
     * Default constructor for test class prueba
     */
    public prueba()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        cliente1= new Cliente("facundo");
        fecha1= new Fecha( 23, 2019);
        lectura1= new Lectura( 21, fecha1);
        coord1= new CoordenadaGPS( 23, 34);
        med1= new MedidorComercial(coord1);
        empresa1= new Empresa();
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
