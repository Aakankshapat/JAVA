import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a target number: ");
        int n = scanner.nextInt();
        
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        
        System.out.println("The sum of numbers from 1 to " + n + " is: " + sum);
        scanner.close();
    }
}

