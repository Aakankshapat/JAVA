import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String original = scanner.next();
        
        String reversed = "";
        // Loop backward from the end of the string to index 0
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        
        System.out.println("Reversed word: " + reversed);
        scanner.close();
    }
}


