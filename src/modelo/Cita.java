package modelo;

public class Cita {
    private String fecha;
    private String hora;
    private Paciente paciente;
    private Dentista dentista;
    private Tratamiento tratamiento;

    public Cita(String fecha, String hora, Paciente paciente, Dentista dentista, Tratamiento tratamiento) {
        validarDatosCita(fecha, hora, paciente, dentista, tratamiento);
    }

    public void validarDatosCita(String fecha, String hora, Paciente paciente, Dentista dentista, Tratamiento tratamiento) {
        if (fecha == null || !fecha.trim().matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$")) {
            throw new IllegalArgumentException("La fecha de la cita debe tener el formato estricto DD/MM/AAAA.");
        }
        if (hora == null || !hora.trim().matches("^(0?[1-9]|1[0-2]):[0-5][0-9]\\s?(AM|PM|am|pm)$")) {
            throw new IllegalArgumentException("La hora '" + hora + "' es inválida. Usa formato HH:MM AM/PM (ej. 03:00 PM).");
        }
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }
        if (dentista == null) {
            throw new IllegalArgumentException("El dentista no puede ser nulo.");
        }
        if (tratamiento == null) {
            throw new IllegalArgumentException("El tratamiento no puede ser nulo.");
        }

        this.fecha = fecha.trim();
        
        String horaLimpia = hora.trim().toUpperCase().replaceAll("\\s+", " ");
        if (horaLimpia.indexOf(':') == 1) {
            horaLimpia = "0" + horaLimpia;
        }
        this.hora = horaLimpia;
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
        System.out.println("La cita del " + fecha + " a las " + hora + " del paciente " + paciente.getNombre() + " ha sido cancelada.");
    }

    public void consultarCita() {
        System.out.println("Fecha: " + fecha + " | Hora: " + hora + " | Paciente: " + paciente.getNombre()
                + " | Dentista: " + dentista.getNombre() + " | Tx: " + tratamiento.getNombreTx()
                + " ($" + tratamiento.calcularCostoTotal() + ")");
    }
}
