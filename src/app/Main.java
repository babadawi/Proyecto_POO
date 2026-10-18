package app;

import modelo.Paciente;
import modelo.Dentista;
import modelo.Tratamiento;
import modelo.Cita;
import servicio.GestorClinica;

public class Main {
    public static void main(String[] args) {
        System.out.println(" BIENVENIDO AL SISTEMA DE CLÍNICA DENTAL \n");

        System.out.println(" 1. Registrando datos ");
        Paciente paciente1 = new Paciente("Juan Pérez", "555-1234", "15/05/1990", "juan@mail.com");
        paciente1.registrarPx(); 
        
        Dentista dentista1 = new Dentista("Dra. Ana López", "CED98765", "ana.lopez@clinica.com");
        dentista1.registrarDentista();

        Tratamiento limpieza = new Tratamiento("Limpieza Dental", 500.0);
        limpieza.registrarTx();
        
        System.out.println(); 

        
        System.out.println(" 2. Agendando y Validando Cita ");
        Cita cita1 = new Cita("20/10/2026", "10:00 AM", paciente1, dentista1, limpieza);
        cita1.agendarCita();
        
        
        GestorClinica gestor = new GestorClinica();
        gestor.confirmarCitaEnSistema(cita1);
        
        System.out.println("\n FIN DE LA DEMOSTRACIÓN ");
    }
}
