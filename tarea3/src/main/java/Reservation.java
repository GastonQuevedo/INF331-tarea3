import java.time.LocalDate;

public class Reservation {
    private String roomCode;
    private String userId;
    private LocalDate date;
    private String details;

    public Reservation(String roomCode, String userId, LocalDate date, String details) {
        this.roomCode = roomCode;
        this.userId = userId;
        this.date = date;
        this.details = details;
    }

    // Getters
    public String getRoomCode() {
        return roomCode;
    }
    public String getUserId() {
        return userId;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getDetails() {
        return details;
    }

    // Setters
    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}