package modelo;

public class HistorialClinico {
    private Paciente paciente;
    private String antecedentesMedicos;
    private String alergias;
    private String ultimaVisita;
    private String notas;

    
    public HistorialClinico(Paciente paciente, String antecedentesMedicos, String alergias, String ultimaVisita, String notas) {
        this.paciente = paciente;
        this.antecedentesMedicos = antecedentesMedicos;
        this.alergias = alergias;
        this.ultimaVisita = ultimaVisita;
        this.notas = notas;
    }

    
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public String getAntecedentesMedicos() { return antecedentesMedicos; }
    public void setAntecedentesMedicos(String antecedentesMedicos) { this.antecedentesMedicos = antecedentesMedicos; }

    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }

    public String getUltimaVisita() { return ultimaVisita; }
    public void setUltimaVisita(String ultimaVisita) { this.ultimaVisita = ultimaVisita; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    
    public void agregarAntecedentes(String nuevosAntecedentes) {
        this.antecedentesMedicos += " | " + nuevosAntecedentes;
        System.out.println("Antecedentes actualizados.");
    }

    public void agregarAlergias(String nuevaAlergia) {
        this.alergias += " | " + nuevaAlergia;
        System.out.println("Alergia agregada.");
    }

    public void editarUltimaVisita(String fechaVisita) {
        this.ultimaVisita = fechaVisita;
        System.out.println("Última visita actualizada a: " + fechaVisita);
    }
    
    public void agregarNotas(String nuevaNota) {
        this.notas += " | " + nuevaNota;
        System.out.println("Notas de evolución actualizadas.");
    }
}
