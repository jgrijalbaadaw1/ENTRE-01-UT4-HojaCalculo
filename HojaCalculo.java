
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author - Javier Grijalba
 *  
 */
public class HojaCalculo
{
    //============= ATTRIBUTES ====================
        // CONS
        // VAR
        private String nombre;
        private Fila fila1;
        private Fila fila2;
        private Fila fila3;
        
    //============= BUILDERS ======================
    
    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)
    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila1 = null;
        this.fila1 = null;
    }

    //============= GETTERS ======================
    
    public String getNombre(){return this.nombre;} /** accesor para el nombre de la hoja */

    public Fila getFila1(){return fila1;} /** accesor para la fila1 */
    
    public Fila getFila2(){return fila2;} /** accesor para la fila2 */

    public Fila getFila3(){return fila3;} /** accesor para la fila3 */
    
    //============= PSEUDO-GETTERS ======================
    
    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas()
    {
        int numeroFilasExisten = 0;
        
        if(fila1 != null){ numeroFilasExisten +=1;}
        if(fila2 != null){ numeroFilasExisten +=1;}
        if(fila3 != null){ numeroFilasExisten +=1;}
        
        return numeroFilasExisten;
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos()
    {
        double total = 0.0;
        
        if(fila1 != null){total += fila1.getIngresos();}
        if(fila2 != null){total += fila2.getIngresos();}
        if(fila3 != null){total += fila3.getIngresos();}
        
        return total;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos()
    {
        double total = 0.0;
        
        if(fila1 != null){total += fila1.getGastos();}
        if(fila2 != null){total += fila2.getGastos();}
        if(fila3 != null){total += fila3.getGastos();}
        
        return total;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio()
    {
        double total = 0.0;
        
        if(fila1 != null){total += fila1.getBeneficio();}
        if(fila2 != null){total += fila2.getBeneficio();}
        if(fila3 != null){total += fila3.getBeneficio();}
        
        return total;
    }
    
    //============= METHODS ======================
    
    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta()
    {
        return (getNumeroFilas() == 3);
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila)
    {
         if(!hojaCompleta())
         {
             System.out.printf("%s no se puede añadir en %s",fila.getId(),this.nombre);
         }
         else
         {
             if(fila1==null)
             {
                 fila1 = fila;
             }
             else
             {
                 if(fila2==null)
                 {
                     fila2 = fila;
                 }
                 else
                 {
                    fila3 = fila;
                 }
             }
         }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos)
    {
        Fila nueva = new Fila(id,fecha,ingresos,gastos);
        this.addFila(nueva);
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja()
    { 
        HojaCalculo nuevaHoja = new HojaCalculo("Duplicada HojaX");
        
        Fila nuevaFila1 = new Fila("");
        nuevaFila1 = fila1.duplicar();
        
        Fila nuevaFila2 = fila2.duplicar();
        Fila nuevaFila3 = fila3.duplicar();
        
        nuevaHoja.addFila(nuevaFila1);
        nuevaHoja.addFila(nuevaFila2);
        nuevaHoja.addFila(nuevaFila3);
        
        return nuevaHoja;
    }

    //============= FORMATERS ======================
    
    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString()
    {
        String salida = "";
        
        salida = String.format("%s\n%8s%15s%15s%15s%15s",this.nombre,"","FECHA","INGRESOS","GASTOS","BENEFICIO");
        
        salida.concat("\n" + fila1.toString());
        salida.concat("\n" + fila2.toString());
        salida.concat("\n" + fila3.toString());
        
        salida.concat("-----------------------------------------------------------------");
        salida.concat(String.format("%38s%15s%15s",this.getTotalIngresos(),this.getTotalGastos(),this.getBeneficio()));
        
        return salida;                    
    }
}
