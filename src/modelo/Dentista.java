package modelo;

public class Dentista {
    private String nombre;
    private String cedula;
    private String correo;

    
    public Dentista(String nombre, String cedula, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    
    public void mostrarDatos() {
        System.out.println("Dentista: " + nombre + " | Cédula: " + cedula);
    }

    public void editarDatos() {
        System.out.println("Actualizando información del dentista...");
    }

    public void registrarDentista() {
        System.out.println("Dr. " + nombre + " registrado exitosamente.");
    }
}
