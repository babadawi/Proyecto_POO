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
        
        
        Paciente paciente1 = new Paciente("Rodrigo Huerta", "555-1235", "15/05/1987", "rodhuerta@mail.com");
        Dentista dentista1 = new Dentista("Dr. Antonio Hernandez", "CED456675", "correo@clinica.com", "ID01", "pass123");

        while (ejecutando) {
            try {
                System.out.println("\n--- MENÚ DE OPERACIONES ---");
                System.out.println("1. Cotizar Tratamiento");
                System.out.println("2. Agendar Cita");
                System.out.println("3. Salir");
                System.out.print("Selecciona una funcionalidad: ");
                
                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.println("\nSelecciona el tipo: 1) General 2) Especialidad");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Nombre del tratamiento: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Costo base: ");
                        double costo = scanner.nextDouble();
                        scanner.nextLine();

                        Tratamiento tratamientoRef; 
                        
                        if (tipo == 1) {
                            tratamientoRef = new TratamientoGeneral(nombre, costo);
                        } else {
                            System.out.print("Costo extra de instrumental especializado: ");
                            double costoExtra = scanner.nextDouble();
                            scanner.nextLine();
                            tratamientoRef = new TratamientoEspecialidad(nombre, costo, costoExtra);
                        }
                        
                        
                        System.out.println("\nCalculando costo...");
                        System.out.println("Costo total a cobrar: $" + tratamientoRef.calcularCostoTotal());
                        break;

                    case 2:
                        System.out.print("\nIngresa la hora de la cita (02:00 PM para provocar fallo): ");
                        String hora = scanner.nextLine();
                        
                        Tratamiento txBase = new TratamientoGeneral("Revisión", 500);
                        Cita nuevaCita = new Cita("23/12/2026", hora, paciente1, dentista1, txBase);
                        
                        gestor.agendarCitaValidada(nuevaCita);
                        break;

                    case 3:
                        ejecutando = false;
                        System.out.println("Cerrando sistema...");
                        break;
                        
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR DE ENTRADA: Ingresaste texto donde se esperaba un número.");
                scanner.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
            } catch (HorarioNoDisponibleException e) {
                System.out.println("ERROR DE NEGOCIO: " + e.getMessage());
            } finally {
                System.out.println(">> [Sistema: Intento de operación finalizado]");
            }
        }
        scanner.close();
    }
}
