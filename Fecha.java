
/**
 *  Modela una fecha
 *  
 *  @author - 
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int año;

    //======= BUILDERS ===========
    
    public Fecha(int dia, int mes, int año)
    {
        this.dia = dia;
        this.mes = mes;
        this.año = año;

    }   

    //========== GETTERS =========
    
    public int getDia(){return dia;}
    
    public int getMes(){return mes;}

    public int getAño(){ return año;}

    //========== SETTERS =========
    
    public void setDia(int dia){this.dia = dia;}

    public void setMes(int mes){this.mes = mes;}

    public void setAño(int año){this.año = año;}

    //========== METHODS =========
    
    /** Devuelve una copia exacta al objeto actual
    */
    public Fecha obtenerCopia()
    {
        Fecha copiaDeFecha = new Fecha(this.dia, this.mes, this.año);
        return copiaDeFecha;
    }

    //======== FORMATTERS ===========
    
    public String toString()
    {
        return this.dia + "/"  + this.mes+ "/" + this.año;
    }
}
