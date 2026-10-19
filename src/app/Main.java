package app;

import modelo.Paciente;
import modelo.Dentista;
import modelo.Tratamiento;
import modelo.Cita;
import servicio.GestorClinica;
import modelo.HistorialClinico;

public class Main {
    public static void main(String[] args) {
        System.out.println(" BIENVENIDO AL SISTEMA DE CLÍNICA DENTAL \n");

        System.out.println(" 1. Registrando datos ");
        Paciente paciente1 = new Paciente("Rodrigo Huerta", "555-1235", "15/05/1987", "rodhuerta@mail.com");
        paciente1.registrarPx(); 
        
        Dentista dentista1 = new Dentista("Dr. Antonio Hernandez", "CED456675", "antonio.hdz@clinica.com", "55-57-67-89-54", "Endodoncia");
        dentista1.registrarDentista();

        Tratamiento limpieza = new Tratamiento("Endodoncia", 3500.0);
        limpieza.registrarTx();
        
        System.out.println(); 

        
        System.out.println(" 2. Agendando y Validando Cita ");
        Cita cita1 = new Cita("23/12/2026", "02:00 PM", paciente1, dentista1, limpieza);
        cita1.agendarCita();
        
        
        GestorClinica gestor = new GestorClinica();
        gestor.confirmarCitaEnSistema(cita1);

        
        System.out.println("\n 3. Gestionando Historial Clínico ");
        HistorialClinico historial1 = new HistorialClinico(paciente1, "Ninguno", "Ninguna", "N/A", "Primera visita");
        
        
        historial1.agregarAntecedentes("Hipertensión controlada");
        historial1.editarAntecedentes("Hipertensión controlada, asma leve");
        
        
        historial1.agregarAlergias("Polen");
        historial1.editarAlergias("Polen y penicilina");
        
        
        historial1.agregarUltimaVisita("12/08/2026");
        historial1.editarUltimaVisita("23/12/2026");
        
        
        historial1.agregarNotas("Se recomendó hacer endodoncia.");
        historial1.editarNotas("El paciente aceptó el tratamiento de endodoncia.");
        
        System.out.println("\n FIN DE LA DEMOSTRACIÓN ");
    }
}
