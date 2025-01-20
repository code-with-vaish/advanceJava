package testClass;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import calciCode.CalculatorDemo;

public class CalculatorTest {
    
    @Test
    public void testAddMethod() {
        CalculatorDemo cm = new CalculatorDemo();
        int num1 = 10;
        int num2 = 20;
        int result = cm.add(num1, num2);
        assertEquals("something wrong.", 30, result);
    }
    
    @Test
    public void testSubMethod() {
        CalculatorDemo cm = new CalculatorDemo();
        assertEquals("something wrong.", 10, cm.subtract(20, 10)); // Corrected expectation
    }
    
    @Test
    public void testDivisionMethod() {
        CalculatorDemo cm = new CalculatorDemo();
        assertEquals("something wrong.", 2, cm.divide(20, 10)); // Corrected expectation
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        CalculatorDemo cm = new CalculatorDemo();
        cm.divide(10, 0);
    }
}
