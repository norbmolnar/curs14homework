import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveAlgorithmsTest {
    RecursiveAlgorithms algorithms = new RecursiveAlgorithms();

    @Test
    public void testSumOfFirstNIntegers() {
        assertEquals(15, algorithms.sumOfFirstNIntegers(5));
        assertEquals(0, algorithms.sumOfFirstNIntegers(0));
        assertEquals(55, algorithms.sumOfFirstNIntegers(10));
    }

    @Test
    public void testSumOfFirstNEvenIntegers() {
        assertEquals(30, algorithms.sumOfFirstNEvenIntegers(5));
        assertEquals(0, algorithms.sumOfFirstNEvenIntegers(0));
        assertEquals(110, algorithms.sumOfFirstNEvenIntegers(10));
    }

    @Test
    public void testRecursiveStringReverse() {
        assertEquals("olleh", algorithms.recursiveStringReverse("hello"));
        assertEquals("a", algorithms.recursiveStringReverse("a"));
        assertEquals("", algorithms.recursiveStringReverse(""));
    }

    @Test
    public void testRecursivePalindromeCheck() {
        assertTrue(algorithms.recursivePalindromeCheck("madam"));
        assertTrue(algorithms.recursivePalindromeCheck("ana"));
        assertFalse(algorithms.recursivePalindromeCheck("hello"));
    }

    @Test
    public void testSumOfDigits() {
        assertEquals(10, algorithms.sumOfDigits(1234));
        assertEquals(0, algorithms.sumOfDigits(0));
        assertEquals(18, algorithms.sumOfDigits(567));
    }

    @Test
    public void testFibonacci() {
        assertEquals(0, algorithms.fibonacci(0));
        assertEquals(1, algorithms.fibonacci(1));
        assertEquals(5, algorithms.fibonacci(5));
        assertEquals(55, algorithms.fibonacci(10));
    }
}
