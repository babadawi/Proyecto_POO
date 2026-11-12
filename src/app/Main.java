package app;

import modelo.*;
import servicio.GestorClinica;
import excepciones.HorarioNoDisponibleException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorClinica gestor = new GestorClinica();
        boolean ejecutando = true;

        System.out.println("=== BIENVENIDO AL SISTEMA DE CLÍNICA DENTAL ===");
        
        
        Paciente pacienteActual = new Paciente("Rodrigo Huerta", "5551234567", "15/05/1987", "rodhuerta@mail.com");
        Dentista dentistaActual = new Dentista("Dr. Antonio Hernandez", "CED456675", "correo@clinica.com", "ID01", "pass123");
        HistorialClinico historialActual = new HistorialClinico(pacienteActual, "Ninguno", "Ninguna", "N/A", "Primera visita");
        
        
        Cita citaActual = null; 

        while (ejecutando) {
                System.out.println("\n--- MENÚ DE OPERACIONES ---");
                System.out.println("1. Registrar Paciente");
                System.out.println("2. Registrar Dentista");
                System.out.println("3. Agregar Antecedentes al Historial");
                System.out.println("4. Cotizar Tratamiento");
                System.out.println("5. Agendar Cita");
                System.out.println("6. Cancelar Cita");
                System.out.println("7. Salir");
                System.out.print("Selecciona una funcionalidad: ");
                
                int opcion = 0;
                try {
                    opcion = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("ERROR DE ENTRADA: Ingresaste texto donde se esperaba un número.");
                    scanner.nextLine();
                    continue; 
                }
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- REGISTRAR PACIENTE ---");
                        System.out.print("Nombre del paciente (no números, no vacío): ");
                        String nombre = scanner.nextLine();
                        System.out.print("Teléfono (10 dígitos exactos): ");
                        String telefono = scanner.nextLine();
                        System.out.print("Fecha de Nacimiento (formato DD/MM/AAAA): ");
                        String fecha = scanner.nextLine();
                        System.out.print("Correo (debe contener @): ");
                        String correo = scanner.nextLine();
                        try {
                            pacienteActual = new Paciente(nombre, telefono, fecha, correo);
                            gestor.registrarPacienteEnSistema(pacienteActual);
                            historialActual = new HistorialClinico(pacienteActual, "Ninguno", "Ninguna", "N/A", "Primera visita");
                            System.out.println("Paciente registrado con éxito.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                        }
                        finally {
                            System.out.println("Intento finalizado.");
                        }
                        break;

                    case 2:
                        System.out.println("\n--- REGISTRAR DENTISTA ---");
                        System.out.print("Nombre del dentista (no vacío): ");
                        String nombreDentista = scanner.nextLine();
                        System.out.print("Cédula profesional (no vacía): ");
                        String cedula = scanner.nextLine();
                        System.out.print("Correo (debe contener @, ej. para forzar error omítelo): ");
                        String correoDentista = scanner.nextLine();
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        try {
                            dentistaActual = new Dentista(nombreDentista, cedula, correoDentista, id, password);
                            dentistaActual.registrarDentista();
                            System.out.println("Dentista registrado con éxito."); 
                        } catch (IllegalArgumentException e) {
                            System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("\n--- GESTIONAR HISTORIAL CLÍNICO ---");
                        System.out.println("Paciente seleccionado: " + pacienteActual.getNombre());
                        System.out.print("Ingresa el nuevo antecedente médico (déjalo vacío para forzar error): ");
                        String nuevoAntecedente = scanner.nextLine();
                        try{
                            historialActual.agregarAntecedentes(nuevoAntecedente);
                            System.out.println("Historial actualizado: " + historialActual.getAntecedentesMedicos());
                        } catch (IllegalArgumentException e) {
                            System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                        }
                        break;

                case 4:
                        System.out.println("\n--- COTIZAR TRATAMIENTO ---");
                        try {
                            System.out.println("Selecciona el tipo: 1) General 2) Especialidad");
                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                        if (tipo != 1 && tipo != 2) {
                            throw new IllegalArgumentException("El tipo debe ser 1 (General) o 2 (Especialidad).");
                        }

                        System.out.print("Nombre del tratamiento: ");
                        String nombreTx = scanner.nextLine();
                        System.out.print("Costo base: ");
                        double costo = scanner.nextDouble();
                        scanner.nextLine();

                        Tratamiento tratamientoRef;

                        if (tipo == 1) {
                            tratamientoRef = new TratamientoGeneral(nombreTx, costo);
                        } else {
                            System.out.print("Costo extra de instrumental especializado: ");
                            double costoExtra = scanner.nextDouble();
                            scanner.nextLine();
                            tratamientoRef = new TratamientoEspecialidad(nombreTx, costo, costoExtra);
                        }

                        System.out.println("Calculando costo...");
                        System.out.println("Costo total a cobrar: $" + tratamientoRef.calcularCostoTotal());

                    } catch (InputMismatchException e) {
                        System.out.println("ERROR DE ENTRADA: Ingresaste texto donde se esperaba un número.");
                        scanner.nextLine(); // limpia el dato incorrecto del buffer
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\n--- AGENDAR CITA ---");
                    System.out.println("Dentista asignado: " + dentistaActual.getNombre());
                    System.out.print("Ingresa la hora de la cita (02:00 PM para provocar fallo): ");
                    String hora = scanner.nextLine();
                    
                    try {
                        Tratamiento txBase = new TratamientoGeneral("Revisión", 500);
                        Cita nuevaCita = new Cita("23/12/2026", hora, pacienteActual, dentistaActual, txBase);
                        gestor.agendarCitaValidada(nuevaCita);
                        citaActual = nuevaCita; 
                        System.out.println("¡Cita agendada con éxito!");
                    } catch (HorarioNoDisponibleException e) {
                        System.out.println("ERROR DE NEGOCIO: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\n--- CANCELAR CITA ---");
                    if (citaActual != null) {
                        citaActual.cancelarCita(); 
                        citaActual = null; 
                    } else {
                        System.out.println("No hay ninguna cita agendada actualmente para cancelar.");
                    }
                    break;

                case 7:
                    ejecutando = false;
                    System.out.println("Cerrando sistema...");
                    break;
                    
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}