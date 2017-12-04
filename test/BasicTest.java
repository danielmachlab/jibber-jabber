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
    public void testMessageEntity(){
        Message msg1 = new Message("hey");
        msg1.save();
        assertTrue(Message.findAll().size() == 1);

        Message msg2 = new Message("Hi there");
        msg2.save();
        assertTrue(Message.findAll().size() == 2);

        assertEquals(msg1, Message.findAll().get(0));
        assertEquals(msg2, Message.findAll().get(1));
    }

}
