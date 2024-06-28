import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class UserManagementTest {
    private UserManagement userManagement;

    @Before
    public void setUp() {
        userManagement = new UserManagement();
    }

    @Test
    public void testAddUser() {
        userManagement.addUser("1", "Fernando Quevedo", "IT", "Engineer");
        User user = userManagement.getUser("1");
        assertNotNull(user);
        assertEquals("Fernando Quevedo", user.getName());
        assertEquals("IT", user.getDepartment());
        assertEquals("Engineer", user.getDescription());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddUserWithDuplicateId() {
        userManagement.addUser("1", "Fernando Quevedo", "IT", "Engineer");
        userManagement.addUser("1", "Nando Quevedo", "HR", "Manager");
    }

    @Test
    public void testUpdateUser() {
        userManagement.addUser("1", "Fernando Quevedo", "IT", "Engineer");
        userManagement.updateUser("1", "Nando Quevedo", "HR", "Manager");
        User user = userManagement.getUser("1");
        assertNotNull(user);
        assertEquals("Nando Quevedo", user.getName());
        assertEquals("HR", user.getDepartment());
        assertEquals("Manager", user.getDescription());
    }

    @Test
    public void testUpdateNonExistentUser() {
        userManagement.updateUser("999", "Gastón Sierralta", "IT", "Engineer");
        User user = userManagement.getUser("999");
        assertNull(user);
    }
    
    @Test
    public void testDeleteUser() {
        userManagement.addUser("1", "Fernando Quevedo", "IT", "Engineer");
        userManagement.deleteUser("1");
        User user = userManagement.getUser("1");
        assertNull(user);
    }
    
    @Test
    public void testDeleteNonExistentUser() {
        userManagement.deleteUser("999");
        User user = userManagement.getUser("999");
        assertNull(user);
    }

    @Test
    public void testReadNonExistentUser() {
        User user = userManagement.getUser("999");
        assertNull(user);
    }
    
    @Test
    public void testGetUsers() {
        userManagement.addUser("1", "Fernando Quevedo", "IT", "Engineer");
        userManagement.addUser("2", "Nando Quevedo", "HR", "Manager");
        List<User> users = userManagement.getUsers();
        assertEquals(2, users.size());
    }
}