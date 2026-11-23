package app;

import modelo.*;
import servicio.GestorClinica;
import excepciones.HorarioNoDisponibleException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorClinica gestor = new GestorClinica();
        boolean ejecutando = true;

        System.out.println("=== BIENVENIDO AL SISTEMA DE CLÍNICA DENTAL ===");

        while (ejecutando) {
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Registrar Dentista");
            System.out.println("3. Gestionar Historial Clínico");
            System.out.println("4. Cotizar Tratamiento (Polimorfismo)");
            System.out.println("5. Agendar Cita");
            System.out.println("6. Consultar / Cancelar Citas");
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
                    try {
                        System.out.print("Nombre del paciente (solo letras, no vacío): ");
                        String nombre = scanner.nextLine();
                        System.out.print("Teléfono (10 dígitos exactos): ");
                        String telefono = scanner.nextLine();
                        System.out.print("Fecha de Nacimiento (DD/MM/AAAA): ");
                        String fecha = scanner.nextLine();
                        System.out.print("Correo (debe contener @): ");
                        String correo = scanner.nextLine();

                        Paciente nuevoPaciente = new Paciente(nombre, telefono, fecha, correo);
                        gestor.registrarPacienteEnSistema(nuevoPaciente);
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    } finally {
                        System.out.println(">> [Sistema: Intento de registro de paciente finalizado]");
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR DENTISTA ---");
                    try {
                        System.out.print("Nombre del dentista (no vacío): ");
                        String nombreDentista = scanner.nextLine();
                        System.out.print("Cédula profesional (no vacía): ");
                        String cedula = scanner.nextLine();
                        System.out.print("Correo (debe contener @): ");
                        String correoDentista = scanner.nextLine();
                        System.out.print("ID de usuario: ");
                        String id = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        Dentista nuevoDentista = new Dentista(nombreDentista, cedula, correoDentista, id, password);
                        gestor.registrarDentistaEnSistema(nuevoDentista);
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    } finally {
                        System.out.println(">> [Sistema: Intento de registro de dentista finalizado]");
                    }
                    break;

                case 3:
                    System.out.println("\n--- GESTIONAR HISTORIAL CLÍNICO ---");
                    try {
                        List<HistorialClinico> historiales = gestor.getHistoriales();
                        for (int i = 0; i < historiales.size(); i++) {
                            System.out.println((i + 1) + ". " + historiales.get(i).getPaciente().getNombre());
                        }
                        System.out.print("Selecciona el número de paciente: ");
                        int idxHist = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (idxHist < 0 || idxHist >= historiales.size()) {
                            throw new IllegalArgumentException("Número de paciente inválido.");
                        }

                        HistorialClinico histSeleccionado = historiales.get(idxHist);
                        System.out.println("Antecedentes actuales: " + histSeleccionado.getAntecedentesMedicos());
                        System.out.println("Última visita: " + histSeleccionado.getUltimaVisita());
                        System.out.println("¿Qué deseas actualizar? 1) Agregar antecedente  2) Registrar fecha de última visita");
                        int subOp = scanner.nextInt();
                        scanner.nextLine();

                        if (subOp == 1) {
                            System.out.print("Nuevo antecedente médico: ");
                            String nuevoAnt = scanner.nextLine();
                            histSeleccionado.agregarAntecedentes(nuevoAnt);
                        } else if (subOp == 2) {
                            System.out.print("Fecha de última visita (DD/MM/AAAA): ");
                            String fechaVis = scanner.nextLine();
                            histSeleccionado.agregarUltimaVisita(fechaVis);
                        } else {
                            throw new IllegalArgumentException("Opción no válida.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR DE ENTRADA: Ingresaste texto donde se esperaba un número.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    } finally {
                        System.out.println(">> [Sistema: Intento de actualización de historial finalizado]");
                    }
                    break;

                case 4:
                    System.out.println("\n--- COTIZAR TRATAMIENTO ---");
                    try {
                        System.out.println("Selecciona el tipo: 1) General  2) Especialidad");
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
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    } finally {
                        System.out.println(">> [Sistema: Intento de cotización finalizado]");
                    }
                    break;

                case 5:
                    System.out.println("\n--- AGENDAR CITA ---");
                    try {
                        List<Paciente> pacientes = gestor.getPacientes();
                        System.out.println("Pacientes disponibles:");
                        for (int i = 0; i < pacientes.size(); i++) {
                            System.out.println((i + 1) + ". " + pacientes.get(i).getNombre());
                        }
                        System.out.print("Selecciona el número de paciente: ");
                        int idxPx = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (idxPx < 0 || idxPx >= pacientes.size()) {
                            throw new IllegalArgumentException("Número de paciente inválido.");
                        }

                        List<Dentista> dentistas = gestor.getDentistas();
                        System.out.println("Dentistas disponibles:");
                        for (int i = 0; i < dentistas.size(); i++) {
                            System.out.println((i + 1) + ". " + dentistas.get(i).getNombre() + " (" + dentistas.get(i).getCedula() + ")");
                        }
                        System.out.print("Selecciona el número de dentista: ");
                        int idxDr = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (idxDr < 0 || idxDr >= dentistas.size()) {
                            throw new IllegalArgumentException("Número de dentista inválido.");
                        }

                        System.out.print("Fecha de la cita (DD/MM/AAAA): ");
                        String fechaCita = scanner.nextLine();
                        System.out.print("Hora de la cita (ej. 03:00 PM): ");
                        String horaCita = scanner.nextLine();

                        System.out.println("Tipo de tratamiento: 1) General  2) Especialidad");
                        int tipoTx = scanner.nextInt();
                        scanner.nextLine();
                        if (tipoTx != 1 && tipoTx != 2) {
                            throw new IllegalArgumentException("El tipo de tratamiento debe ser 1 o 2.");
                        }

                        System.out.print("Nombre del tratamiento: ");
                        String nomTx = scanner.nextLine();
                        System.out.print("Costo base: ");
                        double costoBase = scanner.nextDouble();
                        scanner.nextLine();

                        Tratamiento txCita;
                        if (tipoTx == 1) {
                            txCita = new TratamientoGeneral(nomTx, costoBase);
                        } else {
                            System.out.print("Costo extra de instrumental: ");
                            double extra = scanner.nextDouble();
                            scanner.nextLine();
                            txCita = new TratamientoEspecialidad(nomTx, costoBase, extra);
                        }

                        Cita nuevaCita = new Cita(fechaCita, horaCita, pacientes.get(idxPx), dentistas.get(idxDr), txCita);
                        gestor.agendarCitaValidada(nuevaCita);
                        System.out.println("Total estimado del tratamiento: $" + txCita.calcularCostoTotal());

                    } catch (InputMismatchException e) {
                        System.out.println("ERROR DE ENTRADA: Ingresaste texto donde se esperaba un número.");
                        scanner.nextLine();
                    } catch (HorarioNoDisponibleException e) {
                        System.out.println("ERROR DE NEGOCIO: " + e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    } finally {
                        System.out.println(">> [Sistema: Intento de agendamiento finalizado]");
                    }
                    break;

                case 6:
                    System.out.println("\n--- CONSULTAR / CANCELAR CITAS ---");
                    try {
                        List<Cita> citas = gestor.getCitas();
                        if (citas.isEmpty()) {
                            System.out.println("No hay citas agendadas actualmente.");
                        } else {
                            for (int i = 0; i < citas.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                citas.get(i).consultarCita();
                            }
                            System.out.print("Ingresa el número de cita a cancelar (o 0 para regresar): ");
                            int numCita = scanner.nextInt();
                            scanner.nextLine();
                            if (numCita > 0) {
                                gestor.cancelarCitaPorIndice(numCita - 1);
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR DE ENTRADA: Ingresaste texto donde se esperaba un número.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR DE VALIDACIÓN: " + e.getMessage());
                    } finally {
                        System.out.println(">> [Sistema: Consulta de citas finalizada]");
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
