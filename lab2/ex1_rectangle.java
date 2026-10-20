// Exercise 1: Rectangle Class - Basic Class Design
import java.util.Scanner;

public class ex1_rectangle {

    // Attributes: private data
    private double width;
    private double height;

    // No-argument constructor: creates a 1 x 1 rectangle
    public ex1_rectangle() {
        this.width = 1;
        this.height = 1;
    }

    // Parameterized constructor: non-positive values are replaced by 1
    public ex1_rectangle(double width, double height) {
        this.width = (width > 0) ? width : 1;
        this.height = (height > 0) ? height : 1;
    }

    // Methods
    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public void displayInfo() {
        System.out.println("Rectangle [width = " + width + ", height = " + height + "]");
        System.out.println("  Area      = " + area());
        System.out.println("  Perimeter = " + perimeter());
    }

    // Test driver
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chiều rộng (width): ");
        double width = sc.nextDouble();

        System.out.print("Nhập chiều cao (height): ");
        double height = sc.nextDouble();

        ex1_rectangle r = new ex1_rectangle(width, height);
        r.displayInfo();

        sc.close();
    }
}