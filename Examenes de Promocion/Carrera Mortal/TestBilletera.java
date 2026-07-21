public class TestBilletera 
{
  public TestBilletera() 
  {
    Precheck();
  }

  public void Precheck () 
  {
    Billetera billetera = new Billetera();
    billetera.agregarDolares(20);
    System.out.println(billetera);
    try 
    {
      billetera.gastar(10);
    } catch (DineroInsuficienteException e) 
    
    {
      System.out.println("ERROR");
    }
    System.out.println(billetera);
  }
}