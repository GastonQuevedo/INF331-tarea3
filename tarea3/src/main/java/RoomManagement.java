import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomManagement {
    private Map<String, Room> rooms;

    public RoomManagement() {
        this.rooms = new HashMap<>();
    }

    public void addRoom(String code, String name, String location) {
        if (rooms.containsKey(code)) {
            throw new IllegalArgumentException("Room with this code already exists.");
        }
        Room room = new Room(code, name, location);
        rooms.put(code, room);
    }

    public Room getRoom(String code) {
        return rooms.get(code);
    }
    
    public List<Room> getRooms() {
        return new ArrayList<>(rooms.values());
    }

    public void updateRoom(String code, String name, String location, boolean reserved) {
        Room room = rooms.get(code);
        if (room != null) {
            room.setName(name);
            room.setLocation(location);
            room.setReserved(reserved);
        }
    }

    public void deleteRoom(String code) {
        rooms.remove(code);
    }
}
