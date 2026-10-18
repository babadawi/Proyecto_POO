package servicio;

import modelo.Cita;
import modelo.Paciente; 

public class GestorClinica {

    public void registrarPacienteEnSistema(Paciente paciente) {
        System.out.println("Registrando paciente en el sistema...");
        paciente.registrarPx(); 
        System.out.println("Paciente " + paciente.getNombre() + " registrado con éxito.");
    }
    
    
    public void confirmarCitaEnSistema(Cita cita) {
        System.out.println("Validando disponibilidad en la clínica...");
        System.out.println("La cita del paciente " + cita.getPaciente().getNombre() + " ha sido confirmada en el sistema.");
    }
}
