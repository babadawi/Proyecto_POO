package servicio;

import modelo.*;
import excepciones.HorarioNoDisponibleException;
import java.util.ArrayList;
import java.util.List;

public class GestorClinica {
    private List<Paciente> pacientes;
    private List<Dentista> dentistas;
    private List<HistorialClinico> historiales;
    private List<Cita> citas;

    public GestorClinica() {
        this.pacientes = new ArrayList<>();
        this.dentistas = new ArrayList<>();
        this.historiales = new ArrayList<>();
        this.citas = new ArrayList<>();

        // Datos iniciales precargados para facilitar pruebas inmediatas
        Paciente pxInicial = new Paciente("Rodrigo Huerta", "5551234567", "15/05/1987", "rodhuerta@mail.com");
        Dentista drInicial = new Dentista("Dr. Antonio Hernandez", "CED456675", "correo@clinica.com", "ID01", "pass123");
        HistorialClinico histInicial = new HistorialClinico(pxInicial, "Ninguno", "Ninguna", "N/A", "Primera visita");

        this.pacientes.add(pxInicial);
        this.dentistas.add(drInicial);
        this.historiales.add(histInicial);
    }

    public void registrarPacienteEnSistema(Paciente paciente) {
        paciente.registrarPx();
        this.pacientes.add(paciente);
        this.historiales.add(new HistorialClinico(paciente, "Ninguno", "Ninguna", "N/A", "Primera visita"));
    }

    public void registrarDentistaEnSistema(Dentista dentista) {
        dentista.registrarDentista();
        this.dentistas.add(dentista);
    }

    public void agendarCitaValidada(Cita nuevaCita) throws HorarioNoDisponibleException {
        System.out.println("Validando disponibilidad para " + nuevaCita.getDentista().getNombre()
                + " el " + nuevaCita.getFecha() + " a las " + nuevaCita.getHora() + "...");

        
        for (Cita c : citas) {
            boolean mismoDentista = c.getDentista().getCedula().equalsIgnoreCase(nuevaCita.getDentista().getCedula());
            boolean mismaFecha = c.getFecha().equals(nuevaCita.getFecha());
            boolean mismaHora = c.getHora().equalsIgnoreCase(nuevaCita.getHora());

            if (mismoDentista && mismaFecha && mismaHora) {
                throw new HorarioNoDisponibleException(
                    "El dentista " + nuevaCita.getDentista().getNombre() + " ya tiene una cita registrada el "
                    + nuevaCita.getFecha() + " a las " + nuevaCita.getHora() + ". La cita no fue registrada."
                );
            }
        }

        this.citas.add(nuevaCita);
        System.out.println("ÉXITO: La cita del paciente " + nuevaCita.getPaciente().getNombre()
                + " ha sido confirmada (Total de citas activas: " + citas.size() + ").");
    }

    public void cancelarCitaPorIndice(int indice) {
        if (indice < 0 || indice >= citas.size()) {
            throw new IllegalArgumentException("El número de cita seleccionado no existe.");
        }
        Cita eliminada = citas.remove(indice);
        eliminada.cancelarCita();
    }

    public List<Paciente> getPacientes() { return pacientes; }
    public List<Dentista> getDentistas() { return dentistas; }
    public List<HistorialClinico> getHistoriales() { return historiales; }
    public List<Cita> getCitas() { return citas; }
}

