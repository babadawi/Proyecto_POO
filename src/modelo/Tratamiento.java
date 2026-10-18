package modelo;

public class Tratamiento {
    private String nombreTx;
    private double costo;

    
    public Tratamiento(String nombreTx, double costo) {
        this.nombreTx = nombreTx;
        this.costo = costo;
    }

  
    public String getNombreTx() { return nombreTx; }
    public void setNombreTx(String nombreTx) { this.nombreTx = nombreTx; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    
    public void registrarTx() {
        System.out.println("El tratamiento " + nombreTx + " ha sido registrado en el catálogo.");
    }

    public void editarCosto(double nuevoCosto) {
        this.costo = nuevoCosto;
        System.out.println("El costo de " + nombreTx + " se actualizó a $" + nuevoCosto);
    }
}
