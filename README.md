## HOLA!:D

Este proyecto usa Java 21.

## Estructura del proyecto.

```text
src/
├── app/
│   └── Main.java
├── excepciones/
│   └── HorarioNoDisponibleException.java
├── modelo/
│   ├── Cita.java
│   ├── Dentista.java
│   ├── HistorialClinico.java
│   ├── Paciente.java
│   ├── Tratamiento.java
│   ├── TratamientoEspecialidad.java
│   └── TratamientoGeneral.java
└── servicio/
    └── GestorClinica.java
```

## Instrucciones para compilar.

1. Crear una terminal en la carpeta `src`.
2. Ejecutar el siguiente comando: `javac excepciones/*.java modelo/*.java servicio/*.java app/*.java`

## Instrucciones para ejecutar.

1. Crear una terminal en la carpeta `src`.
2. Ejecutar el siguiente comando: `java app.Main`

## Funcionalidades disponibles.

En el menú principal podemos elegir una de las siguientes opciones:

1. Registrar Paciente: Crea un paciente e inicializa su historial clínico, validando que su información personal tenga el formato correcto.
2. Registrar Dentista: Registra un nuevo dentista en el sistema asegurando que sus datos profesionales sean válidos.
3. Agregar Antecedentes al Historial: Añade nuevos registros médicos al historial del paciente actual.
4. Cotizar Tratamiento: Calcula el costo total dependiendo de si el tratamiento solicitado es general o de especialidad.
5. Agendar Cita: Programa una cita para el paciente verificando que el formato de la hora sea correcto y que el horario se encuentre disponible en la clínica.
6. Cancelar Cita: Cancela la cita activa actualmente.
7. Salir: Termina la ejecución del programa.

## Limitaciones conocidas.

- El proyecto no almacena en memoria los datos que agregamos durante una ejecución, por lo que siempre que lo iniciamos este solo cuenta con la información base.

## Reproducción de los casos de prueba.

### Caso 1

Selecciona la opción 4, elige el tipo 1, ingresa el nombre "Limpieza" y un costo de 500. El sistema mostrará correctamente el costo total calculado.

### Caso 2

Selecciona la opción 4, elige el tipo 2, ingresa el nombre "Endodoncia", un costo base de 1000 y un costo extra de 300. El sistema mostrará el costo total sumando el cargo adicional.

### Caso 3

En el menú principal, teclea una letra en lugar de un número. El sistema mostrará un error de entrada y te permitirá elegir de nuevo sin cerrarse.

### Caso 4

Selecciona la opción 1 e ingresa un nombre que contenga números (por ejemplo "Ana777"). Se rechazarán los datos indicando el motivo.

### Caso 5

Selecciona la opción 5 e ingresa la hora "02:00 PM", el programa indicará que el horario ya está ocupado.

### Caso 6

Después del paso anterior, vuelve a seleccionar la opción 5 e ingresa una hora disponible, se creará la cita exitosamente.

### Caso 7

Selecciona la opción 1 y realiza un registro con datos incorrectos, luego repite la opción 1 con datos correctos. En ambos escenarios se imprime el mensaje "Intento finalizado" al terminar.
