# INF331-tarea3
# Gestión de Salas - JUnit

## Tabla de contenidos
* [Descripción del Diseño del Programa](#descripción-del-diseño-del-programa)
* [Manual de Usuario](#manual-de-usuario)
* [Reporte de Resultados de las Pruebas Unitarias](#reporte-de-resultados-de-las-pruebas-unitarias)

## Descripción del Diseño del Programa
Este programa es una aplicación de línea de comandos desarrollada en Java para gestionar la reserva de salas de reuniones en una organización. El sistema permite gestionar usuarios, salas y reservas, e incluye pruebas unitarias utilizando JUnit para asegurar la calidad del código.

### Componentes Principales
* User: Representa a un usuario con atributos como identificador, nombre, departamento y descripción.
* Room: Representa una sala de reuniones con atributos como código, nombre, ubicación y estado de reserva.
* Reservation: Representa una reserva de una sala por un usuario en una fecha específica con detalles adicionales.
* UserManagement: Gestiona las operaciones CRUD para los usuarios.
* RoomManagement: Gestiona las operaciones CRUD para las salas.
* ReservationManagement: Gestiona las operaciones CRUD para las reservas.
* Tarea3: Contiene el menú principal y gestiona la interacción con el usuario a través de la línea de comandos.

### Validaciones
* No se pueden agregar usuarios, salas o reservas con IDs duplicados.
* Las reservas solo se pueden crear con IDs de usuario y sala existentes.
* No se pueden crear reservas duplicadas para la misma sala, usuario y fecha.

## Manual de Usuario

### Requisitos Previos
* Tener instalado JDK (Java Development Kit).
* Tener instalado un IDE (por ejemplo, NetBeans, Eclipse) o estar familiarizado con el uso de la línea de comandos para ejecutar programas Java.
* Tener JUnit 4 o superior configurado en el entorno de desarrollo.

### Instrucciones para Ejecutar el Programa
1. Clonar el Repositorio.
2. Compilar el Código.
3. Ejecutar el Programa.
4. Uso del Menú Principal: El programa mostrará un menú con las opciones para gestionar usuarios, salas y reservas. Selecciona una opción ingresando el número correspondiente y sigue las instrucciones en pantalla.

### Gestión de Usuarios
* Agregar Usuario: Proporciona el ID, nombre, departamento y descripción del usuario.
* Ver Usuario: Proporciona el ID del usuario para ver sus detalles.
* Actualizar Usuario: Proporciona el ID del usuario y los nuevos detalles para actualizar.
* Eliminar Usuario: Proporciona el ID del usuario para eliminarlo.
* Ver Todos los Usuarios: Muestra una lista de todos los usuarios.

### Gestión de Salas
* Agregar Sala: Proporciona el código, nombre y ubicación de la sala.
* Ver Sala: Proporciona el código de la sala para ver sus detalles.
* Actualizar Sala: Proporciona el código de la sala y los nuevos detalles para actualizar.
* Eliminar Sala: Proporciona el código de la sala para eliminarla.
* Ver Todas las Salas: Muestra una lista de todas las salas.

### Gestión de Reservas
* Crear Reserva: Proporciona el código de la sala, ID del usuario, fecha y detalles de la reserva.
* Ver Reserva: Proporciona el código de la sala, ID del usuario y fecha para ver los detalles de la reserva.
* Actualizar Reserva: Proporciona el código de la sala, ID del usuario, fecha y nuevos detalles para actualizar.
* Eliminar Reserva: Proporciona el código de la sala, ID del usuario y fecha para eliminar la reserva.
* Ver Todas las Reservas: Muestra una lista de todas las reservas.

## Reporte de Resultados de las Pruebas Unitarias
Las pruebas unitarias se implementaron utilizando JUnit y cubren las funcionalidades CRUD de usuarios, salas y reservas, así como las validaciones asociadas.

```
Running ReservationManagementTest
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.085 s -- in ReservationManagementTest
Running RoomManagementTest
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s -- in RoomManagementTest
Running UserManagementTest
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 s -- in UserManagementTest

Results:

Tests run: 25, Failures: 0, Errors: 0, Skipped: 0
```