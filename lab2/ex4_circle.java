
import java.util.Scanner;

class Circle {

    private double centerX;
    private double centerY;
    private double radius;

    public Circle() {
        this.centerX = 0;
        this.centerY = 0;
        this.radius = 1;
    }

    public Circle(double centerX, double centerY, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        double dx = x - centerX;
        double dy = y - centerY;
        return dx * dx + dy * dy <= radius * radius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter center X: ");
        double a = sc.nextDouble();
        System.out.print("Enter center Y: ");
        double b = sc.nextDouble();
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        Circle circle = new Circle(a, b, r);
        System.out.printf("Area      = %.4f%n", circle.area());
        System.out.printf("Perimeter = %.4f%n", circle.perimeter());

        System.out.print("How many points do you want to test? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter point " + i + " (x y): ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            if (circle.contains(x, y)) {
                System.out.println("(" + x + ", " + y + ") is inside or on the circle.");
            } else {
                System.out.println("(" + x + ", " + y + ") is outside the circle.");
            }
        }

        sc.close();

        /*
         * TESTS
         *
         * Test 1: default unit circle
         *   Circle c = new Circle();
         *   c.area();                  // PI  ~ 3.1416
         *   c.perimeter();             // 2*PI ~ 6.2832
         *
         * Test 2: circle centered at (1, 1) with radius 2
         *   Circle c = new Circle(1, 1, 2);
         *   c.contains(1, 1);          // true  (center)
         *   c.contains(3, 1);          // true  (on the boundary)
         *   c.contains(1, 3.5);        // false (outside)
         *   c.contains(0, 0);          // true  (dx=-1, dy=-1, distance^2 = 2 <= 4)
         *
         * Test 3: invalid radius -> IllegalArgumentException "Radius must be greater than 0"
         *   new Circle(0, 0, 0);
         *   new Circle(0, 0, -3);
         */
    }
}