/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both
 * {@link Demo#main(String[])} and
 * {@link Demo#isTriangle(double, double, double)}).
 */
 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;

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

         String expectedOutput = "Enter side 1: \n" +
                                 "Enter side 2: \n" +
                                 "Enter side 3: \n" +
                                 "This is a triangle.\n";

         Demo.main(new String[] {});
         assertEquals(expectedOutput, getConsoleOutput());
     }

     @Test
     public void testMain_InvalidTriangleInput() {
         String input = "1\n2\n10\n";
         InputStream in = new ByteArrayInputStream(input.getBytes());
         System.setIn(in);

         String expectedOutput = "Enter side 1: \n" +
                                 "Enter side 2: \n" +
                                 "Enter side 3: \n" +
                                 "This is not a triangle.\n";

         Demo.main(new String[] {});
         assertEquals(expectedOutput, getConsoleOutput());
     }

     private String getConsoleOutput() {
         return outContent.toString();
     }

     // Define outContent to capture console output
     private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
     private final PrintStream originalOut = System.out;

     @BeforeEach
     public void setUpStreams() {
         System.setOut(new PrintStream(outContent));
     }

     @AfterEach
     public void restoreStreams() {
         System.setOut(originalOut);
     }
 }
