package modelo;

public class Dentista {
    private String nombre;
    private String cedula;
    private String correo;
    private String id;
    private String password;

    public Dentista(String nombre, String cedula, String correo, String id, String password) {
        validarDatosDentista(nombre, cedula, correo, id, password);
    }

    public void validarDatosDentista(String nombre, String cedula, String correo, String id, String password) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del dentista no puede estar vacío.");
        }
        
        
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula profesional es obligatoria.");
        }
        
        
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El formato del correo electrónico del dentista es inválido.");
        }

        this.nombre = nombre.trim();
        this.cedula = cedula.trim();
        this.correo = correo.trim();
        this.id = id; 
        this.password = password; 
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void mostrarDatos() {
        System.out.println("Dentista: " + nombre + " | Cédula: " + cedula);
    }

    public void editarDatos() {
        System.out.println("Actualizando información del dentista...");
    }

    public void registrarDentista() {
        System.out.println("Dentista " + nombre + " registrado exitosamente.");
    }

    public void crearUsuario() {
        System.out.println("Usuario creado para el dentista " + nombre + " con ID: " + id);
    }
}
