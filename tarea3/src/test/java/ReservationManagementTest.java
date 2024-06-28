import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.*;

public class ReservationManagementTest {
    private ReservationManagement reservationManagement;
    private UserManagement userManagement;
    private RoomManagement roomManagement;

    @Before
    public void setUp() {
        userManagement = new UserManagement();
        roomManagement = new RoomManagement();
        reservationManagement = new ReservationManagement(userManagement, roomManagement);
        
        userManagement.addUser("1", "Fernando Quevedo", "IT", "Engineer");
        userManagement.addUser("2", "Nando Quevedo", "HR", "Manager");
        roomManagement.addRoom("101", "Conference Room", "First Floor");
        roomManagement.addRoom("102", "Meeting Room", "Second Floor");
    }

    @Test
    public void testAddReservation() {
        reservationManagement.addReservation("101", "1", LocalDate.of(2024, 6, 27), "Team Meeting");
        Reservation reservation = reservationManagement.getReservation("101", "1", LocalDate.of(2024, 6, 27));
        assertNotNull(reservation);
        assertEquals("Team Meeting", reservation.getDetails());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReservationWithDuplicate() {
        reservationManagement.addReservation("101", "1", LocalDate.of(2024, 6, 27), "Team Meeting");
        reservationManagement.addReservation("101", "1", LocalDate.of(2024, 6, 27), "Another Meeting");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReservationWithNonExistentRoom() {
        reservationManagement.addReservation("999", "1", LocalDate.of(2024, 6, 27), "Non Existent Room");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddReservationWithNonExistentUser() {
        reservationManagement.addReservation("101", "999", LocalDate.of(2024, 6, 27), "Non Existent User");
    }

    @Test
    public void testUpdateReservation() {
        reservationManagement.addReservation("101", "1", LocalDate.of(2024, 6, 27), "Team Meeting");
        reservationManagement.updateReservation("101", "1", LocalDate.of(2024, 6, 27), "Updated Meeting");
        Reservation reservation = reservationManagement.getReservation("101", "1", LocalDate.of(2024, 6, 27));
        assertNotNull(reservation);
        assertEquals("Updated Meeting", reservation.getDetails());
    }

    @Test
    public void testUpdateNonExistentReservation() {
        reservationManagement.updateReservation("999", "999", LocalDate.of(2024, 6, 27), "Updated Meeting");
        Reservation reservation = reservationManagement.getReservation("999", "999", LocalDate.of(2024, 6, 27));
        assertNull(reservation);
    }

    @Test
    public void testDeleteReservation() {
        reservationManagement.addReservation("101", "1", LocalDate.of(2024, 6, 27), "Team Meeting");
        reservationManagement.deleteReservation("101", "1", LocalDate.of(2024, 6, 27));
        Reservation reservation = reservationManagement.getReservation("101", "1", LocalDate.of(2024, 6, 27));
        assertNull(reservation);
    }

    @Test
    public void testDeleteNonExistentReservation() {
        reservationManagement.deleteReservation("999", "999", LocalDate.of(2024, 6, 27));
        Reservation reservation = reservationManagement.getReservation("999", "999", LocalDate.of(2024, 6, 27));
        assertNull(reservation);
    }

    @Test
    public void testGetReservations() {
        reservationManagement.addReservation("101", "1", LocalDate.of(2024, 6, 26), "Team Meeting");
        reservationManagement.addReservation("102", "2", LocalDate.of(2024, 6, 27), "Project Update");
        List<Reservation> reservations = reservationManagement.getReservations();
        assertEquals(2, reservations.size());
    }
}