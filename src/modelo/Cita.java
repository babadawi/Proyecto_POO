package modelo;

public class Cita {
    private String fecha;
    private String hora;
    private Paciente paciente;
    private Dentista dentista;
    private Tratamiento tratamiento;

    
    public Cita(String fecha, String hora, Paciente paciente, Dentista dentista, Tratamiento tratamiento) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.dentista = dentista;
        this.tratamiento = tratamiento;
    }

    
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Dentista getDentista() { return dentista; }
    public void setDentista(Dentista dentista) { this.dentista = dentista; }

    public Tratamiento getTratamiento() { return tratamiento; }
    public void setTratamiento(Tratamiento tratamiento) { this.tratamiento = tratamiento; }

    
    public void agendarCita() {
        System.out.println("Cita agendada el " + fecha + " a las " + hora + " para " + paciente.getNombre());
    }

    public void cancelarCita() {
        System.out.println("La cita del paciente " + paciente.getNombre() + " ha sido cancelada.");
    }

    public void consultarCita() {
        System.out.println("Consulta de cita: " + paciente.getNombre() + " con el Dr. " + dentista.getNombre() + " para " + tratamiento.getNombreTx());
    }
}
