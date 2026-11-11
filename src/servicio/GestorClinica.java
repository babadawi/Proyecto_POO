package servicio;

import modelo.Cita;
import modelo.Paciente; 
import excepciones.HorarioNoDisponibleException;

public class GestorClinica {

    public void registrarPacienteEnSistema(Paciente paciente) {
        paciente.registrarPx(); 
    }
    
    public void agendarCitaValidada(Cita cita) throws HorarioNoDisponibleException {
        
        if (!cita.getHora().matches("^(0?[1-9]|1[0-2]):[0-5][0-9]\\s?(AM|PM|am|pm)$")) {
            throw new IllegalArgumentException("La hora '" + cita.getHora() + "' es inválida. Debe tener minutos entre 00 y 59 y formato AM/PM (ejemplo: 01:30 PM).");
        }

        System.out.println("Validando disponibilidad en la clínica para las " + cita.getHora() + "...");
        
        
        if (cita.getHora().equalsIgnoreCase("02:00 PM")) {
            throw new HorarioNoDisponibleException("El horario de las " + cita.getHora() + " ya se encuentra ocupado. La cita no fue registrada.");
        }
        
        System.out.println("ÉXITO: La cita del paciente " + cita.getPaciente().getNombre() + " ha sido confirmada en el sistema.");
    }
}

