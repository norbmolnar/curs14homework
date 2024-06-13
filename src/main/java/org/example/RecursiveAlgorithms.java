public class RecursiveAlgorithms {

    public int sumOfFirstNIntegers(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumOfFirstNIntegers(n - 1);
    }

    public int sumOfFirstNEvenIntegers(int n) {
        if (n <= 0) {
            return 0;
        }
        return 2 * n + sumOfFirstNEvenIntegers(n - 1);
    }

    public String recursiveStringReverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + recursiveStringReverse(s.substring(0, s.length() - 1));
    }

    public boolean recursivePalindromeCheck(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return recursivePalindromeCheck(s.substring(1, s.length() - 1));
    }

    public int sumOfDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 + sumOfDigits(num / 10);
    }

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        RecursiveAlgorithms algorithms = new RecursiveAlgorithms();

        // Testing sumOfFirstNIntegers
        System.out.println("Sum of first 5 integers: " + algorithms.sumOfFirstNIntegers(5)); // 15
        System.out.println("Sum of first 10 integers: " + algorithms.sumOfFirstNIntegers(10)); // 55

        // Testing sumOfFirstNEvenIntegers
        System.out.println("Sum of first 5 even integers: " + algorithms.sumOfFirstNEvenIntegers(5)); // 30
        System.out.println("Sum of first 10 even integers: " + algorithms.sumOfFirstNEvenIntegers(10)); // 110

        // Testing recursiveStringReverse
        System.out.println("Reverse of 'hello': " + algorithms.recursiveStringReverse("hello")); // "olleh"
        System.out.println("Reverse of 'a': " + algorithms.recursiveStringReverse("a")); // "a"

        // Testing recursivePalindromeCheck
        System.out.println("Is 'madam' a palindrome? " + algorithms.recursivePalindromeCheck("madam")); // true
        System.out.println("Is 'hello' a palindrome? " + algorithms.recursivePalindromeCheck("hello")); // false

        // Testing sumOfDigits
        System.out.println("Sum of digits of 1234: " + algorithms.sumOfDigits(1234)); // 10
        System.out.println("Sum of digits of 567: " + algorithms.sumOfDigits(567)); // 18

        // Testing fibonacci
        System.out.println("5th Fibonacci number: " + algorithms.fibonacci(5)); // 5
        System.out.println("10th Fibonacci number: " + algorithms.fibonacci(10)); // 55
    }
}
