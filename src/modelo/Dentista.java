package modelo;

public class Dentista {
    private String nombre;
    private String cedula;
    private String correo;
    private String id;
    private String password;

    
    public Dentista(String nombre, String cedula, String correo, String id, String password) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.id = id; 
        this.password = password; 
    }

    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public void mostrarDatos() {
        System.out.println("Dentista: " + nombre + " | Cédula: " + cedula);
    }

    public void editarDatos() {
        System.out.println("Actualizando información del dentista...");
    }

    public void registrarDentista() {
        System.out.println("Dentista " + nombre + " registrado exitosamente.");
    }

    public void crearUsuario(){
        System .out.println("Usuario creado para el dentista " + nombre + " con ID: " + id);
    }
}
