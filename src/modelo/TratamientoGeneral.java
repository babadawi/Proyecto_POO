package modelo;

public class TratamientoGeneral extends Tratamiento {
    
    public TratamientoGeneral(String nombreTx, double costoBase) {
        super(nombreTx, costoBase);
    }

    @Override
    public double calcularCostoTotal() {
        
        return super.getCostoBase(); 
    }
}
