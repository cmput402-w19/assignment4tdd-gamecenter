import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ConnectFourTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConnectFourTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ConnectFourTest.class);
    }

    public void testDefault() {
        assertTrue(true);
    }
}