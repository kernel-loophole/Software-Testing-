import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class DemoTest {

    @Test
    public void testIsTriangle_ValidTriangle() {
        assertTrue(Demo.isTriangle(3, 4, 5));
    }

    @Test
    public void testIsTriangle_InvalidTriangle() {
        assertFalse(Demo.isTriangle(1, 2, 10));
    }

    @Test
    public void testMain_ValidTriangleInput() {
        String input = "3\n4\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String expectedOutput = "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is a triangle.\n";

        Demo.main(new String[] {});
        assertEquals(expectedOutput, getConsoleOutput());
    }
    @Test
    public void testMain_ValidTriangleInput_2() {
        String input = "3\n4\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String expectedOutput = "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is a triangle.\n";

        Demo.main(new String[] {});
        assertEquals(expectedOutput, getConsoleOutput());
    }

    @Test
    public void testMain_InvalidTriangleInput() {
        String input = "1\n2\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String expectedOutput = "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is not a triangle.\n";

        Demo.main(new String[] {});
        assertEquals(expectedOutput, getConsoleOutput());
    }

    private String getConsoleOutput() {
        return outContent.toString();
    }

    // Define outContent to capture console output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
	
}
