package modelo;

public class Tratamiento {
    protected String nombreTx;
    protected double costoBase;

    public Tratamiento(String nombreTx, double costoBase) {
        // Validar que el nombre no esté vacío ni contenga únicamente espacios
        if (nombreTx == null || nombreTx.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del tratamiento no puede estar vacío.");
        }
        
        // Validar que el nombre contenga letras y no sea solo números o símbolos
        if (!nombreTx.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            throw new IllegalArgumentException("El nombre del tratamiento '" + nombreTx + "' debe contener solo letras.");
        }

        if (costoBase <= 0) {
            throw new IllegalArgumentException("El costo base debe ser un valor positivo mayor a cero.");
        }
        
        this.nombreTx = nombreTx.trim();
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
