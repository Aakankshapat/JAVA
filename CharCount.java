import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Enter character to count: ");
        char target = scanner.next().charAt(0);
        
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == target) {
                count++;
            }
        }
        
        System.out.println("The character '" + target + "' appears " + count + " times.");
        scanner.close();
    }
}