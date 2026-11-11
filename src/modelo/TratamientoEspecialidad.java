package modelo;

public class TratamientoEspecialidad extends Tratamiento {
    private double costoMaterialExtra;

    public TratamientoEspecialidad(String nombreTx, double costoBase, double costoMaterialExtra) {
        super(nombreTx, costoBase);
        if (costoMaterialExtra < 0) {
            throw new IllegalArgumentException("El costo de material extra no puede ser negativo.");
        }
        this.costoMaterialExtra = costoMaterialExtra;
    }

    @Override
    public double calcularCostoTotal() {
        
        return super.getCostoBase() + this.costoMaterialExtra; 
    }
}
