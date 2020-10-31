
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author Javier Grijalba
 *  
 */
public class Fila
{
    // ATRIBUTES
        // CONSTANTS
        
        // VARIABLES
        private String id;
        private Fecha fecha;
        private double ingresos;
        private double gastos;
    
    //======== BUILDERS ==========
    
    public Fila(String id)
    {
        this.id = id;
    }

    public Fila(String id, Fecha fecha, double ingresos, double gastos)
    {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.gastos = gastos;
    }
    
    //======== GETTERS ==========
    
    public String getId(){return this.id;}

    public Fecha getFecha(){ return this.fecha;}
    
    public double getIngresos(){return this.ingresos;}

    public double getGastos(){return this.gastos;}
    
    public double getBeneficio(){return (this.ingresos - this.gastos);}

    //======== METHODS ==========
    
    /**
     * obtiene una copia idéntica a la fila actual.
     * La fecha que incluye la fila duplicada también es una copia
     */
    public Fila duplicar()
    {
        Fila copiaDeFila = new Fila(getId(), getFecha(), getIngresos(), getGastos());
        return copiaDeFila;
    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString()
    {
        String idL = this.id;
        String fechaL = this.fecha.toString();
        double ingresosL = this.ingresos;
        double gastosL = this.gastos;
        double saldo = ingresosL - gastosL;
        
        String salida = String.format("%8s%15s%15.2f€%15.2f€%15.2f€",idL,fechaL,ingresosL,gastosL,saldo);
        
        if(saldo < 0)
        {
            salida = salida + " **";
        }
        
        return salida;
    }
}
