import java.util.Scanner;

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Width: ");
        double w = sc.nextDouble();
        System.out.print("Height: ");
        double h = sc.nextDouble();
        
        System.out.println("Area: " + calculateArea(w, h));
        System.out.println("Perimeter: " + calculatePerimeter(w, h));
        sc.close();
    }
    
    public static double calculateArea(double width, double height) {
        return width * height;
    }
    
    public static double calculatePerimeter(double width, double height) {
        return 2 * (width + height);
    }
}
