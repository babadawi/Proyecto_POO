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

Para ejecutar el proyecto: 
1. Presionar el botón verde que dice "Code"
2. Elegir "Download ZIP"
3. Abra la carpeta src en su IDE o terminal con el JDK instalado
3. Ejecute el archivo Main.java ubicado en el paquete app

## Instrucciones para ejecutar.



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

- El proyecto no almacena 
