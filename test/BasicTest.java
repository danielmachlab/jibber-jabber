import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void UserCreateTest() {
        User ted = new User("123", "ted");
        ted.save();
        List<User> users = User.findAll();

        assertEquals(users.size(), 1);
        assertTrue(users.get(0).userName.equals("ted"));
    }

}
