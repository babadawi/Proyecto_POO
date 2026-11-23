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

Al iniciar, el sistema precarga un paciente base (`Rodrigo Huerta`) y un dentista base (`Dr. Antonio Hernandez`) para agilizar las pruebas. En el menú principal podemos elegir una de las siguientes opciones:

1. **Registrar Paciente:** Crea un paciente e inicializa su historial clínico en memoria, validando que su nombre solo contenga letras, teléfono de 10 dígitos, fecha `DD/MM/AAAA` y correo con `@`.
2. **Registrar Dentista:** Registra un nuevo dentista en el sistema asegurando que su nombre, cédula profesional y correo sean válidos.
3. **Gestionar Historial Clínico:** Permite seleccionar cualquier paciente registrado para añadir nuevos antecedentes médicos o actualizar la fecha de su última visita.
4. **Cotizar Tratamiento:** Calcula el costo total mediante polimorfismo dependiendo de si el tratamiento solicitado es general o de especialidad.
5. **Agendar Cita:** Vincula un paciente, un dentista, fecha, hora y tratamiento, verificando dinámicamente que el dentista no tenga otra cita registrada en esa misma fecha y hora.
6. **Consultar / Cancelar Citas:** Muestra la lista numerada de citas activas en la sesión y permite cancelar cualquiera por su número.
7. **Salir:** Termina la ejecución del programa.

## Limitaciones conocidas.

* El proyecto almacena los registros en memoria temporal (`ArrayList`) únicamente durante la sesión activa; al cerrar el programa los datos no persisten en archivos ni base de datos, por lo que al reiniciar vuelve a contar solo con la información base.
* La interacción se realiza exclusivamente mediante consola.
* No se utilizaron hilos ni patrones de diseño externos, ya que la arquitectura en paquetes y el polimorfismo cubren las necesidades del sistema.

## Reproducción de los casos de prueba.

### Caso 1
Selecciona la opción `4`, elige el tipo `1`, ingresa el nombre `"Limpieza"` y un costo de `500`. El sistema mostrará correctamente el costo total calculado (`$500.0`).

### Caso 2
Selecciona la opción `4`, elige el tipo `2`, ingresa el nombre `"Endodoncia"`, un costo base de `1000` y un costo extra de `300`. El sistema mostrará el costo total sumando el cargo adicional (`$1300.0`).

### Caso 3
En el menú principal, teclea una letra en lugar de un número. El sistema mostrará un error de entrada (`InputMismatchException`) y te permitirá elegir de nuevo sin cerrarse.

### Caso 4
Selecciona la opción `1` e ingresa un nombre que contenga números (por ejemplo `"Ana777"`) o un teléfono inválido. Se rechazarán los datos mediante `IllegalArgumentException` indicando el motivo.

### Caso 5
Selecciona la opción `5` y agenda una cita para el dentista `1` el `28/11/2026` a las `"03:00 PM"`. Después vuelve a entrar a la opción `5` e intenta agendar otra cita con el mismo dentista, fecha y hora (`"03:00 PM"`): el sistema lanzará `HorarioNoDisponibleException` indicando que el horario ya está ocupado y conservará intacta la primera cita.

### Caso 6
Después del paso anterior, consulta la opción `6` para verificar que la cita previa sigue guardada y vuelve a seleccionar la opción `5` ingresando una hora disponible (por ejemplo `"04:00 PM"`); la nueva cita se creará exitosamente.

### Caso 7
Selecciona la opción `1` (o la opción `5`) y realiza un intento con datos incorrectos y otro con datos válidos. En ambos escenarios se imprime el mensaje de cierre del bloque `finally` (`>> [Sistema: Intento de registro de paciente finalizado]` / `>> [Sistema: Intento de agendamiento finalizado]`) al terminar.

### Caso 8
En una misma ejecución, registra un nuevo paciente (opción `1`), registra un nuevo dentista (opción `2`), agrega un antecedente médico al historial de ese paciente (opción `3`) y finalmente agéndale una cita vinculando al paciente, al dentista y un tratamiento de especialidad (opción `5`), comprobando la integración completa del sistema.
