package gamecenter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class menuTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public menuTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( menuTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMenu()
    {
        assertTrue( true );
    }
}