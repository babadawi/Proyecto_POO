package modelo;

public class Paciente {
    private String nombre;
    private String telefono;
    private String fechaNacimiento;
    private String correo;

    public Paciente(String nombre, String telefono, String fechaNacimiento, String correo) {
        validarDatosPacient(nombre, telefono, fechaNacimiento, correo);
    }

    public void validarDatosPaciente(String nombre, String telefono, String fechaNacimiento, String correo) {
        if (nombre == null || nombre.trim().isEmpty() || !nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            throw new IllegalArgumentException("El nombre del paciente '" + nombre + "' es inválido. Solo debe contener letras.");
        }
        
        
        if (telefono == null || !telefono.trim().matches("^\\d{10}$")) {
            throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos numéricos.");
        }

        
        if (fechaNacimiento == null || !fechaNacimiento.trim().matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$")) {
            throw new IllegalArgumentException("La fecha de nacimiento debe tener el formato estricto DD/MM/AAAA.");
        }

        
        if (correo == null || !correo.trim().contains("@")) {
            throw new IllegalArgumentException("El correo electrónico del paciente debe contener un '@'.");
        }

        this.nombre = nombre.trim();
        this.telefono = telefono.trim();
        this.fechaNacimiento = fechaNacimiento.trim();
        this.correo = correo.trim();
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


