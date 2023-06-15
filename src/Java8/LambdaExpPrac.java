package Java8;

import java.util.function.Predicate;

public class LambdaExpPrac {
    public static void main(String[] args) {
        oddCheck(5);
        oddCheck(6);
        System.out.println("--------------------------------------------------");
        isPrime(5);
        isPrime(6);
        System.out.println("--------------------------------------------------");
        isPalindrome(13431);
        isPalindrome(11);
        isPalindrome(2122);
        System.out.println("--------------------------------------------------");
    }

    static void isPalindrome(int num) {
        Predicate<Integer> isPalindrome = (n) -> {
            String numString = Integer.toString(n);
            return numString.equals(new StringBuilder(numString).reverse().toString());
        };
        System.out.printf("Checking %d is palindrome : " + isPalindrome.test(num), num);
        System.out.println();;
    }
    static void isPrime(int num) {
        Predicate<Integer> isPrime = (n) -> {
            for(int i=2; i<n/2 ; i++)
                if (n%i == 0)
                    return true;
            return false;
        };
        System.out.printf("Checking %d is prime : " + isPrime.test(num), num);
        System.out.println();
    }
    static void oddCheck(int num) {
        Predicate<Integer> isOdd = (n) -> n%2!=0;
        System.out.printf("Checking if %d is odd : " + isOdd.test(num), num);
        System.out.println();

    }
}