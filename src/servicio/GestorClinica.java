package servicio;

import modelo.Cita;

public class GestorClinica {
    
    
    public void confirmarCitaEnSistema(Cita cita) {
        System.out.println("Validando disponibilidad en la clínica...");
        System.out.println("La cita del paciente " + cita.getPaciente().getNombre() + " ha sido confirmada en el sistema.");
    }
}
