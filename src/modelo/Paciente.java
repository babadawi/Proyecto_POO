package modelo;

public class Paciente {
    private String nombre;
    private String telefono;
    private String fechaNacimiento;
    private String correo;

    public Paciente(String nombre, String telefono, String fechaNacimiento, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

  
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    
    public void mostrarDatosPx() {
        System.out.println("Paciente: " + nombre + " | Teléfono: " + telefono + " | Correo: " + correo);
    }

    public void editarDatosPx() {
        System.out.println("Editando datos del paciente " + nombre + "...");
    }

    public void registrarPx() {
        System.out.println("Paciente " + nombre + " registrado en el sistema con éxito.");
    }
}
