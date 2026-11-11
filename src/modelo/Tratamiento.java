package modelo;

public class Tratamiento {
    protected String nombreTx;
    protected double costoBase;

    public Tratamiento(String nombreTx, double costoBase) {
        if (costoBase <= 0) {
            throw new IllegalArgumentException("El costo base debe ser un valor positivo mayor a cero.");
        }
        this.nombreTx = nombreTx;
        this.costoBase = costoBase;
    }

    public String getNombreTx() { return nombreTx; }
    public void setNombreTx(String nombreTx) { this.nombreTx = nombreTx; }

    public double getCostoBase() { return costoBase; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }

    public double calcularCostoTotal() {
        return costoBase;
    }
    
    public void registrarTx() {
        System.out.println("El tratamiento " + nombreTx + " ha sido registrado.");
    }
}
