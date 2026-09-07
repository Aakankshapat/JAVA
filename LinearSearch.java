import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = {12, 45, 78, 23, 56, 89, 91};
        
        System.out.print("Enter a number to search for: ");
        int key = scanner.nextInt();
        int foundIndex = -1;
        
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key) {
                foundIndex = i;
                break;
            }
        }
        
        if (foundIndex != -1) {
            System.out.println("Element found at position index: " + foundIndex);
        } else {
            System.out.println("Element not found in the array.");
        }
        scanner.close();
    }
}
