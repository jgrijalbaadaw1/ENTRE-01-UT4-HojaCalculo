public class TestFila
{
   
    private Fecha fecha1;
    private Fila fila1;
    private Fila filaDuplicada;
    
    public TestFila()
    {
        fecha1 = new Fecha(4,1,1998);
        fila1 = new Fila("Fila1", fecha1, 48.3459, 136.8754);
        filaDuplicada = fila1.duplicar();
    }

    public void imprimir()
    {
        System.out.print("\u000C");
        System.out.println(fila1.toString());
        System.out.println(filaDuplicada.toString());
        System.out.println();
        
        System.out.println(fila1);
        System.out.println(fila1);
        System.out.println(filaDuplicada);
        
    }
}
