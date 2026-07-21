

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class REGISTROSS.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class REGISTROSS
{
    private Llamada llamada1;
    private Llamada llamada2;
    private visor visor1;
    private RegistroDeLlamadas reg1;
    private Fecha fecha1;
    private Fecha fecha2;
    private String s;
    /**
     * Default constructor for test class REGISTROSS
     */
    public REGISTROSS()
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
        fecha1= new Fecha( 2016,12, 3, 23, 54);
        fecha2= new Fecha(2017, 3, 34, 55, 22);       
        llamada1= new Llamada("3525540653", fecha1, 34 , TipoDeLlamada.ENTRANTE);
        llamada2= new Llamada("3513398263", fecha2, 45, TipoDeLlamada.SALIENTE);
        reg1= new RegistroDeLlamadas();
        visor1= new visor();
        s= new String("facundo \n  es un capo");
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
