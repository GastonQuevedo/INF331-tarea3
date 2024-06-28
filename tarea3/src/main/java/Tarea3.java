import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Tarea3 {
    private static UserManagement userManagement = new UserManagement();
    private static RoomManagement roomManagement = new RoomManagement();
    private static ReservationManagement reservationManagement = new ReservationManagement(userManagement, roomManagement);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Salas");
            System.out.println("3. Gestión de Reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    manageUsers(scanner);
                    break;
                case 2:
                    manageRooms(scanner);
                    break;
                case 3:
                    manageReservations(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void manageUsers(Scanner scanner) {
        int option;

        do {
            System.out.println("\nGestión de Usuarios");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Ver Usuario");
            System.out.println("3. Actualizar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Ver Todos los Usuarios");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String department = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String description = scanner.nextLine();
                    try {
                        userManagement.addUser(id, name, department, description);
                        System.out.println("Usuario agregado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("ID: ");
                    id = scanner.nextLine();
                    User user = userManagement.getUser(id);
                    if (user != null) {
                        System.out.println(user);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("ID: ");
                    id = scanner.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    name = scanner.nextLine();
                    System.out.print("Nuevo Departamento: ");
                    department = scanner.nextLine();
                    System.out.print("Nueva Descripción: ");
                    description = scanner.nextLine();
                    userManagement.updateUser(id, name, department, description);
                    System.out.println("Usuario actualizado exitosamente.");
                    break;
                case 4:
                    System.out.print("ID: ");
                    id = scanner.nextLine();
                    userManagement.deleteUser(id);
                    System.out.println("Usuario eliminado exitosamente.");
                    break;
                case 5:
                    System.out.println("Lista de Usuarios:");
                    for (User u : userManagement.getUsers()) {
                        System.out.println(u);
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 6);
    }

    private static void manageRooms(Scanner scanner) {
        int option;

        do {
            System.out.println("\nGestión de Salas");
            System.out.println("1. Agregar Sala");
            System.out.println("2. Ver Sala");
            System.out.println("3. Actualizar Sala");
            System.out.println("4. Eliminar Sala");
            System.out.println("5. Ver Todas las Salas");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Código: ");
                    String code = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Ubicación: ");
                    String location = scanner.nextLine();
                    try {
                        roomManagement.addRoom(code, name, location);
                        System.out.println("Sala agregada exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Código: ");
                    code = scanner.nextLine();
                    Room room = roomManagement.getRoom(code);
                    if (room != null) {
                        System.out.println(room);
                    } else {
                        System.out.println("Sala no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Código: ");
                    code = scanner.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    name = scanner.nextLine();
                    System.out.print("Nueva Ubicación: ");
                    location = scanner.nextLine();
                    System.out.print("Estado de Reserva (true para reservada, false para disponible): ");
                    boolean reserved = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    roomManagement.updateRoom(code, name, location, reserved);
                    System.out.println("Sala actualizada exitosamente.");
                    break;
                case 4:
                    System.out.print("Código: ");
                    code = scanner.nextLine();
                    roomManagement.deleteRoom(code);
                    System.out.println("Sala eliminada exitosamente.");
                    break;
                case 5:
                    System.out.println("Lista de Salas:");
                    for (Room r : roomManagement.getRooms()) {
                        System.out.println(r);
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 6);
    }

    private static void manageReservations(Scanner scanner) {
        int option;

        do {
            System.out.println("\nGestión de Reservas");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Ver Reserva");
            System.out.println("3. Actualizar Reserva");
            System.out.println("4. Eliminar Reserva");
            System.out.println("5. Ver Todas las Reservas");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Código de la Sala: ");
                    String roomCode = scanner.nextLine();
                    System.out.print("ID del Usuario: ");
                    String userId = scanner.nextLine();
                    System.out.print("Fecha (yyyy-MM-dd): ");
                    String dateString = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
                    System.out.print("Detalles: ");
                    String details = scanner.nextLine();
                    try {
                        reservationManagement.addReservation(roomCode, userId, date, details);
                        System.out.println("Reserva creada exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Código de la Sala: ");
                    roomCode = scanner.nextLine();
                    System.out.print("ID del Usuario: ");
                    userId = scanner.nextLine();
                    System.out.print("Fecha (yyyy-MM-dd): ");
                    dateString = scanner.nextLine();
                    date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
                    Reservation reservation = reservationManagement.getReservation(roomCode, userId, date);
                    if (reservation != null) {
                        System.out.println(reservation);
                    } else {
                        System.out.println("Reserva no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Código de la Sala: ");
                    roomCode = scanner.nextLine();
                    System.out.print("ID del Usuario: ");
                    userId = scanner.nextLine();
                    System.out.print("Fecha (yyyy-MM-dd): ");
                    dateString = scanner.nextLine();
                    date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
                    System.out.print("Nuevos Detalles: ");
                    details = scanner.nextLine();
                    reservationManagement.updateReservation(roomCode, userId, date, details);
                    System.out.println("Reserva actualizada exitosamente.");
                    break;
                case 4:
                    System.out.print("Código de la Sala: ");
                    roomCode = scanner.nextLine();
                    System.out.print("ID del Usuario: ");
                    userId = scanner.nextLine();
                    System.out.print("Fecha (yyyy-MM-dd): ");
                    dateString = scanner.nextLine();
                    date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
                    reservationManagement.deleteReservation(roomCode, userId, date);
                    System.out.println("Reserva eliminada exitosamente.");
                    break;
                case 5:
                    System.out.println("Lista de Reservas:");
                    for (Reservation res : reservationManagement.getReservations()) {
                        System.out.println(res);
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 6);
    }
}