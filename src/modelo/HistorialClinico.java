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
        System.out.println("Nuevos antecedentes agregados correctamente.");
    }

    public void editarAntecedentes(String antecedentesActualizados) {
        
        this.antecedentesMedicos = antecedentesActualizados;
        System.out.println("Los antecedentes médicos han sido reemplazados con éxito.");
    }

    
    public void agregarAlergias(String nuevaAlergia) {
        this.alergias += " | " + nuevaAlergia;
        System.out.println("Nueva alergia registrada en el historial.");
    }

    public void editarAlergias(String alergiasActualizadas) {
        this.alergias = alergiasActualizadas;
        System.out.println("La lista de alergias ha sido corregida.");
    }

    
    public void agregarUltimaVisita(String fechaVisita) {
        this.ultimaVisita = fechaVisita;
        System.out.println("Fecha de última visita registrada: " + fechaVisita);
    }

    public void editarUltimaVisita(String nuevaFechaVisita) {
        this.ultimaVisita = nuevaFechaVisita;
        System.out.println("La fecha de la última visita ha sido corregida a: " + nuevaFechaVisita);
    }
    
    
    public void agregarNotas(String nuevaNota) {
        this.notas += " | " + nuevaNota;
        System.out.println("Nueva nota de evolución agregada al paciente.");
    }

    public void editarNotas(String notasActualizadas) {
        this.notas = notasActualizadas;
        System.out.println("Las notas de evolución han sido modificadas.");
    }
}
