import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagement {
    private Map<String, User> users;

    public UserManagement() {
        this.users = new HashMap<>();
    }

    public void addUser(String id, String name, String department, String description) {
        if (users.containsKey(id)) {
            throw new IllegalArgumentException("User with this ID already exists.");
        }
        User user = new User(id, name, department, description);
        users.put(id, user);
    }

    public User getUser(String id) {
        return users.get(id);
    }
    
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public void updateUser(String id, String name, String department, String description) {
        User user = users.get(id);
        if (user != null) {
            user.setName(name);
            user.setDepartment(department);
            user.setDescription(description);
        }
    }

    public void deleteUser(String id) {
        users.remove(id);
    }
}
