import junit.framework.TestCase;
import model.User;

/**
 * Created by bramd on 24-2-2017.
 */
public class UserTest extends TestCase {
    public void testSetName() throws Exception {
        User u = new User();
        u.setName("test");
        assertEquals(u.getName(), "test");
    }
}