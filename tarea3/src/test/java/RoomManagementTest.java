import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class RoomManagementTest {
    private RoomManagement roomManagement;

    @Before
    public void setUp() {
        roomManagement = new RoomManagement();
    }

    @Test
    public void testAddRoom() {
        roomManagement.addRoom("101", "Conference Room", "First Floor");
        Room room = roomManagement.getRoom("101");
        assertNotNull(room);
        assertEquals("Conference Room", room.getName());
        assertEquals("First Floor", room.getLocation());
        assertFalse(room.isReserved());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddRoomWithDuplicateCode() {
        roomManagement.addRoom("101", "Conference Room", "First Floor");
        roomManagement.addRoom("101", "Meeting Room", "Second Floor");
    }

    @Test
    public void testUpdateRoom() {
        roomManagement.addRoom("101", "Conference Room", "First Floor");
        roomManagement.updateRoom("101", "Meeting Room", "Second Floor", true);
        Room room = roomManagement.getRoom("101");
        assertNotNull(room);
        assertEquals("Meeting Room", room.getName());
        assertEquals("Second Floor", room.getLocation());
        assertTrue(room.isReserved());
    }
    
    @Test
    public void testUpdateNonExistentRoom() {
        roomManagement.updateRoom("999", "Meeting Room", "Second Floor", true);
        Room room = roomManagement.getRoom("999");
        assertNull(room);
    }

    @Test
    public void testDeleteRoom() {
        roomManagement.addRoom("101", "Conference Room", "First Floor");
        roomManagement.deleteRoom("101");
        Room room = roomManagement.getRoom("101");
        assertNull(room);
    }
    
    @Test
    public void testDeleteNonExistentRoom() {
        roomManagement.deleteRoom("999");
        Room room = roomManagement.getRoom("999");
        assertNull(room);
    }

    @Test
    public void testReadNonExistentRoom() {
        Room room = roomManagement.getRoom("999");
        assertNull(room);
    }
    
    @Test
    public void testGetRooms() {
        roomManagement.addRoom("101", "Conference Room", "First Floor");
        roomManagement.addRoom("102", "Meeting Room", "Second Floor");
        List<Room> rooms = roomManagement.getRooms();
        assertEquals(2, rooms.size());
    }
}