import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        
        if (num1 >= num2 && num1 >= num3) {
            System.out.println(num1 + " is the largest.");
        } else if (num2 >= num1 && num2 >= num3) {
            System.out.println(num2 + " is the largest.");
        } else {
            System.out.println(num3 + " is the largest.");
        }
        scanner.close();
    }
}
