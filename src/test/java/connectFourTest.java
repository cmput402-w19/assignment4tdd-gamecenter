import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class connectFourTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public connectFourTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(connectFourTest.class);
    }

    public void testDefault() {
        assertTrue(true);
    }
}