import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int num = scanner.nextInt();
        
        boolean isPrime = num > 1; // 0 and 1 are not prime numbers
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false; // Found a factor, so it is not prime
                break;
            }
        }
        
        if (isPrime) {
            System.out.println(num + " is a PRIME number.");
        } else {
            System.out.println(num + " is NOT a prime number.");
        }
        scanner.close();
    }
}
