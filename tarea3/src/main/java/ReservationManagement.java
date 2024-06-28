import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationManagement {
    private List<Reservation> reservations = new ArrayList<>();
    private UserManagement userManagement;
    private RoomManagement roomManagement;

    public ReservationManagement(UserManagement userManagement, RoomManagement roomManagement) {
        this.userManagement = userManagement;
        this.roomManagement = roomManagement;
    }

    public void addReservation(String roomCode, String userId, LocalDate date, String details) {
        if (roomManagement.getRoom(roomCode) == null) {
            throw new IllegalArgumentException("Room with this code does not exist.");
        }
        if (userManagement.getUser(userId) == null) {
            throw new IllegalArgumentException("User with this ID does not exist.");
        }
        for (Reservation reservation : reservations) {
            if (reservation.getRoomCode().equals(roomCode) &&
                reservation.getUserId().equals(userId) &&
                reservation.getDate().equals(date)) {
                throw new IllegalArgumentException("Reservation already exists for this room, user, and date.");
            }
        }
        reservations.add(new Reservation(roomCode, userId, date, details));
    }

    public Reservation getReservation(String roomCode, String userId, LocalDate date) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomCode().equals(roomCode) &&
                reservation.getUserId().equals(userId) &&
                reservation.getDate().equals(date)) {
                return reservation;
            }
        }
        return null;
    }
    
    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public void updateReservation(String roomCode, String userId, LocalDate date, String details) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomCode().equals(roomCode) &&
                reservation.getUserId().equals(userId) &&
                reservation.getDate().equals(date)) {
                reservation.setDetails(details);
                return;
            }
        }
    }

    public void deleteReservation(String roomCode, String userId, LocalDate date) {
        reservations.removeIf(reservation -> 
            reservation.getRoomCode().equals(roomCode) &&
            reservation.getUserId().equals(userId) &&
            reservation.getDate().equals(date)
        );
    }
}