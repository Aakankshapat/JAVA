import java.util.Scanner;

public class StarPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pattern height: ");
        int n = scanner.nextInt();
        
        // Outer loop controls rows
        for (int i = 1; i <= n; i++) {
            // Inner loop controls stars in each row
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line
        }
        scanner.close();
    }
}