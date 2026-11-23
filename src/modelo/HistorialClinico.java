package modelo;

public class HistorialClinico {
    private Paciente paciente;
    private String antecedentesMedicos;
    private String alergias;
    private String ultimaVisita;
    private String notas;

    public HistorialClinico(Paciente paciente, String antecedentesMedicos, String alergias, String ultimaVisita, String notas) {
        if (paciente == null) {
            throw new IllegalArgumentException("El historial clínico debe estar asociado a un paciente válido.");
        }
        if (ultimaVisita != null && !ultimaVisita.equals("N/A") && !ultimaVisita.trim().matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$")) {
            throw new IllegalArgumentException("La última visita debe ser 'N/A' o tener el formato DD/MM/AAAA.");
        }
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
        if (nuevosAntecedentes == null || nuevosAntecedentes.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo de antecedentes médicos no puede estar vacío.");
        }
        this.antecedentesMedicos += " | " + nuevosAntecedentes.trim();
        System.out.println("Nuevos antecedentes agregados correctamente.");
    }

    public void editarAntecedentes(String antecedentesActualizados) {
        if (antecedentesActualizados == null || antecedentesActualizados.trim().isEmpty()) {
            throw new IllegalArgumentException("Los antecedentes actualizados no pueden estar vacíos.");
        }
        this.antecedentesMedicos = antecedentesActualizados.trim();
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
        if (fechaVisita == null || !fechaVisita.trim().matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}$")) {
            throw new IllegalArgumentException("La fecha de visita debe tener el formato estricto DD/MM/AAAA.");
        }
        this.ultimaVisita = fechaVisita.trim();
        System.out.println("Fecha de última visita registrada: " + this.ultimaVisita);
    }

    public void editarUltimaVisita(String nuevaFechaVisita) {
        agregarUltimaVisita(nuevaFechaVisita);
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
