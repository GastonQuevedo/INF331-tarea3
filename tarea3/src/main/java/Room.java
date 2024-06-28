public class Room {
    private String code;
    private String name;
    private String location;
    private boolean reserved;

    public Room(String code, String name, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
        this.reserved = false;
    }

    // Getters
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public boolean isReserved() {
        return reserved;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}