import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number (A): ");
        int a = scanner.nextInt();
        System.out.print("Enter second number (B): ");
        int b = scanner.nextInt();
        
        // Swapping logic
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("After swapping: A = " + a + ", B = " + b);
        scanner.close();
    }
}